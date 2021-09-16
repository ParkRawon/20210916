package co.po.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.po.prj.notice.service.NoticeMapper;
import co.po.prj.notice.service.NoticeService;
import co.po.prj.notice.vo.NoticeVO;

@Repository("noticeDao")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper map;
	
	@Override
	public NoticeVO noticeSearch(int id) {
		// 게시물 검색(id로 검색)
		return map.noticeSearch(id);
	}

	@Override
	public List<NoticeVO> noticeWriterSearch(String key, String val) {
		// 게시물 검색(여러개 검색 가능하게)
		return map.noticeWriterSearch(key, val);
	}

}