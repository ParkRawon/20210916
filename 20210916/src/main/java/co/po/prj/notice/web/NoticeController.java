package co.po.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.po.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
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
	
//	@PostMapping("/wSearch.do")  //작성자로 검색한 결과
//	String wSearch(@RequestParam("userId")String writer, Model model) {
//		model.addAttribute("notices", noticeDao.noticeWriteSearch(writer));
//		
//		return "notice/wSearch";
//	}
	
	@RequestMapping("/noticeMultiSearch.do")  //다중검색 폼 호출
	String noticeMultiSearch(){
			
		return "notice/noticeMultiSearch";
	}
	
	@PostMapping("/bMultiSearch.do")  //다중검색 결과
	String bMultiSearch(@RequestParam("key")String Key,   //폼에서 전달되는 변수를 담음
						@RequestParam("keyValue")String val,
						Model model) {
		model.addAttribute("lists", noticeDao.noticeWriterSearch(Key, val));
		
		return "notice/bMultiSearch";
	}
}	

