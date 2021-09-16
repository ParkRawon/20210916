package co.po.prj.member.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.po.prj.member.service.MemberMapper;
import co.po.prj.member.service.MemberService;
import co.po.prj.member.vo.MemberVO;

@Repository("memberDao")
public class MemberServiecImpl implements MemberService {

	@Autowired
	private MemberMapper map;
	
	@Override
	public MemberVO memberSearch(String id) {
		// 회원 검색
		return map.memberSearch(id);
	}

}
