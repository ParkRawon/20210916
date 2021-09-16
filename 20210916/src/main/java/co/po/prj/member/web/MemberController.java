package co.po.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.po.prj.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired  //의존성 주입
	private MemberService memberDao;
	
	@RequestMapping("/memberSearch.do")  //검색 폼으로 이동
	String memberSearch(Model model) {
		
		return "member/memberSearch";		
	}
	
	@RequestMapping("/mSearch.do")   //검색 결과
	String mSearch(@RequestParam("userid") String id, Model model) { //@RequestParam: 폼에서 넘어온 userid를 string타입으로 넘겨주세요
		model.addAttribute("searchResult", memberDao.memberSearch(id));
		
		return "member/mSearch";
	}
}
