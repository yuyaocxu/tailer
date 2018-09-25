package me.cxy.demo.service.impl;

import org.springframework.stereotype.Service;

import me.cxy.demo.service.BService;

@Service
public class BServiceImpl implements BService {

	@Override
	public void b() {
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
