package co.po.prj.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.po.prj.notice.service.NoticeService;
import co.po.prj.notice.vo.NoticeVO;

@RestController
public class NoticeAjaxController {
	@Autowired
	private NoticeService noticeDao;
	
	@PostMapping("/ajaxNoticeSearch.do")
	List<NoticeVO> search(
			@RequestParam("key")String key,   //폼에서 전달되는 변수를 담음
			@RequestParam("keyValue")String val,
			NoticeVO notice) {
		List<NoticeVO> list = noticeDao.noticeWriterSearch(key, val);

		return list;				
		}
	}
