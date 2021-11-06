package com.ev.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	private final static Logger log = Logger.getLogger(TestController.class);

	@RequestMapping("/")
	public String test() {
		return "test";
	}
}
