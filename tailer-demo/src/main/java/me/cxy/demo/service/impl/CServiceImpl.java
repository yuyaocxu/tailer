package me.cxy.demo.service.impl;

import org.springframework.stereotype.Service;

import me.cxy.demo.service.CService;

@Service
public class CServiceImpl implements CService {

	@Override
	public void c() {
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
