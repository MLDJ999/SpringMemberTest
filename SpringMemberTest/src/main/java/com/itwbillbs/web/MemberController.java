package com.itwbillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwbillbs.domain.MemberVO;
import com.itwbillbs.service.MemberService;

@Controller
@RequestMapping(value = "/naver/*")
public class MemberController {
	
	@Inject
	private MemberService mService;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/naver/memberJoin
	// 회원가입 GET
	@RequestMapping(value = "/memberJoin" , method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug(" memberJoinGET() 실행 - 회원정보 입력 ");	
	}
	
	// 회원가입(처리) POST
	@RequestMapping(value = "/memberJoin" , method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPOST() 실행 - 회원가입 처리");
		logger.debug(" 전달 정보 : " + vo);
		
		mService.memberJoin(vo);
		logger.debug(" 회원가입 성공 " + vo.getUsername());
		
		
		return "redirect:/naver/login";
	}
	
	// 로그인 GET
	// http://localhost:8088/naver/login
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug(" /naver/login -> memberLoginGET() 호출 ");
		logger.debug(" /naver/login.jsp 페이지 연결 ");
	}
		
	// 로그인 POST
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo, HttpSession session
	/* ,@ModelAttribute("userpw") String userpw */
	/* ,@RequestParam("userid") String userid */) {
		logger.debug(" login.jsp ->memberLoginPOST() 호출 ");
		// 1. 전달정보 저장(+한글처리 인코딩)
		logger.debug(" 로그인 정보 vo : "+vo);
		// 2. 서비스 ->  DB에 로그인 처리 동작 호출
		MemberVO resultVO = mService.memberLogin(vo);
		
		String addr ="";
		if(resultVO == null) {
			logger.debug(" 로그인 실패! -> 다시 로그인 ");
			addr = "/naver/login";
		}else {
			logger.debug(" 로그인 성공!! -> 메인페이지 ");
			
			// 로그인 성공한 사용자의 아이디 정보를 세션에 저장
			session.setAttribute("id", resultVO.getUserid());
			
			//return "redirect:/member/main";
			addr = "/naver/main";
		}		
		
		return "redirect:"+addr;
	}
	
	// 메인페이지
	// http://localhost:8088/naver/main
	@GetMapping(value = "/main")
	public String memberMainGET() {
		logger.debug(" /naver/main -> memberMainGET()실행 ");
		logger.debug(" /naver/main.jsp 페이지 이동");		
		
		return "/naver/main";
	}
	
	// 로그아웃 GET
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.debug(" /naver/logout -> memberLogoutGET() 실행 ");
		
		session.invalidate();
		logger.debug(" 세션객체 초기화(로그아웃) ");
		
		return "redirect:/naver/main";
	}
	
	// 회원정보 조회 GET
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void memberInfoGET(HttpSession session, Model model) {
		logger.debug("/naver/info -> memberInfoGET() 실행 ");
		
		String id = (String) session.getAttribute("id");
		logger.debug("id : " + id);
		
		MemberVO resultVO = mService.memberInfo(id);
		model.addAttribute("resultVO", resultVO);
	}
	
	// http://localhost:8088/naver/update
	// 회원정보 수정 GET
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void memberUpdateGET(HttpSession session, Model model) {
		logger.debug(" memberUpdateGET() 실행 ! ");
		
		String id = (String) session.getAttribute("id");
		MemberVO resultVO = mService.memberInfo(id);
		logger.debug(" resultVO : " + resultVO);
		
		model.addAttribute("resultVO", resultVO);
	}
	
	// 회원정보 수정 POST
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO vo) {
		logger.debug(" memberUpdatePOST() 호출 ");
		
		int result = mService.memberUpdate(vo);
		logger.debug("결과 : " + result);
		
		if(result == 1) {
			return "redirect:/naver/main";
		}
		
		return "redirect:/naver/update";
	}
	
	// 회원정보 삭제 GET
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String memberDeleteGET() {
		logger.debug(" memberDeleteGET() 호출 ");
		
		return "/naver/delete";
	}
	
	@RequestMapping(value = "/delete" , method = RequestMethod.POST)
	public String memberDeletePOST(MemberVO vo, HttpSession session) {
		logger.debug(" memberDeletePOST() 호출 ");
		logger.debug(" vo(삭제회원정보) : " + vo);
		
		int result = mService.memberDelete(vo);
		if(result == 1) {
			session.invalidate();
			return "redirect:/naver/main";
		}
		
		// 비밀번호 오류
		return "redirect:/naver/delete";
	}
	
	// 회원 리스트 (관리자) GET
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberListGET(MemberVO vo, Model model, HttpSession session) {
		logger.debug(" memberListGET() 호출");
		String id = (String)session.getAttribute("id");
		if(id == null || !id.equals("admin")) {
			return "redirect:/naver/login";
		}
		
		List<MemberVO> memberList = mService.memberList();
		model.addAttribute("memberList", memberList);
		
		return "/naver/list";
	}

}












