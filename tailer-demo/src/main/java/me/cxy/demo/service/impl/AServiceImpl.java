package me.cxy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.cxy.demo.service.AService;
import me.cxy.demo.service.CService;

@Service
public class AServiceImpl implements AService {

	@Autowired
	private CService cService;
	
	
	@Override
	public void a() {
		cService.c();
		try {
			Thread.sleep(1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
