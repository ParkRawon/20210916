package co.po.prj.member.service;

import co.po.prj.member.vo.MemberVO;

public interface MemberMapper {
	MemberVO memberSearch(String id);  //String 타입인 id변수로 받겠다..?
}
