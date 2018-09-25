package me.cxy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.cxy.tailer.Tailer;
import me.cxy.tailer.boss.Boss;
import me.cxy.tailer.boss.impl.SimpleBoss;

@SpringBootApplication
public class TailerDemo{

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TailerDemo.class);
		app.run(args);
	}
	
	@Bean
	public Tailer createTailer() {
		return new Tailer(createBoss());
	}
	
	@Bean
	public Boss createBoss() {
		return new SimpleBoss();
	}
	
}
