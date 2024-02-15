package com.itwbillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/naver/*")
public class MemberController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// http://localhost:8088/naver/memberJoin
	@RequestMapping(value = "/memberJoin", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug(" memberJoinGET() 실행 - 회원가입 ");
		logger.debug(" 연결된 뷰페이지(/WEB-INF/views/naver/memberJoin.jsp)");
	}
	
	

}
