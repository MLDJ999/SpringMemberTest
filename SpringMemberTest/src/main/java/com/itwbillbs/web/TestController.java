package com.itwbillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	//http://localhost:8088/Test1
	@RequestMapping(value = "/Test1", method = RequestMethod.GET)
	public void Test1() {
		logger.debug(" Test1() 호출! ");
	}
	
	

}
