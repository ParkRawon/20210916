package co.po.prj.notice.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.po.prj.notice.service.NoticeService;
import co.po.prj.notice.vo.NoticeVO;


@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@Autowired
	private String uploadPath; //파일이 저장될 경로
	
	@RequestMapping("/noticeSearch.do")  //게시글 검색 폼 호출
	String noticeSearch() {	
		
		return "notice/noticeSearch";
	}
	
	@PostMapping("/bSearch.do")  //id로 검색한 결과 
	String bSearch(@RequestParam("bid")int bid,      //폼에서 전달되는 변수를 담음
//			       @RequestParam("writer")String writer,
			       Model model) {
		model.addAttribute("bResult", noticeDao.noticeSearch(bid));
		
		
		return "notice/noticeResult";
	}
	
//연습용	@PostMapping("/wSearch.do")  //작성자로 검색한 결과 
//	String wSearch(@RequestParam("userId")String writer, Model model) {
//		model.addAttribute("notices", noticeDao.noticeWriterSearch("a",writer));
//		
//		return "notice/wSearch";
//	}
	
	@RequestMapping("/noticeMultiSearch.do")  //다중검색 폼 호출
	String noticeMultiSearch(){
			
		return "notice/noticeMultiSearch";
	}
	
//	@PostMapping("/ajaxNoticeSearch.do")  //다중검색 결과(한페이지에 나오게 하기)
//	@ResponseBody  //호출한 페이지 본체로 돌려주라(ajax로 호출)
//	List<NoticeVO> ajaxNoticeSearch
//						(@RequestParam("key")String key,   //폼에서 전달되는 변수를 담음
//						 @RequestParam("keyValue")String val,
//						 NoticeVO notice) {
//		System.out.println(key);
//		System.out.println(val);
//		System.out.println("=====");
//		List<NoticeVO> list = noticeDao.noticeWriterSearch(key, val);  //리스트에 담는다
//		
//		return list;				
//	}
	
	@RequestMapping("/noticeForm.do") //공지사항 등록 폼 호출
	String noticeForm() {
		return "notice/noticeForm";
	}
	
	@RequestMapping("/noticeInsert.do")  //게시물등록,파일업로드 결과 페이지 
	String noticeInsert(MultipartFile attchfile, NoticeVO notice, Model model, HttpServletRequest request){
		String fileName = attchfile.getOriginalFilename();  //파일명 구하기
		notice.setFileName(fileName);  //넘어온 파일명 실어주기
		notice.setWriter("park");   //작성자 id 담기
		String filepath = request.getSession().getServletContext().getRealPath("/") + "//fileUp//";
		File saveFile = new File(filepath, fileName);  //파일객체를 통해서 디렉토리명과 파일명을 실어줌
		try {
			attchfile.transferTo(saveFile); //파일저장
			if(saveFile.exists()) { //saveFile이 존재하면
				noticeDao.noticeInsert(notice);
			}else {
				model.addAttribute("message", fileName+"저장실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message","파일전송 실패");
		}
		
		return "notice/noticeInsertResult";
	}
}	

