package me.cxy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cxy.demo.service.AService;
import me.cxy.demo.service.BService;

@RestController
public class TestController {

	@Autowired
	private AService aService;
	@Autowired
	private BService bService;
	
	@GetMapping("/test")
	public String test() {
		aService.a();
		bService.b();
		return "ok";
	}
}
