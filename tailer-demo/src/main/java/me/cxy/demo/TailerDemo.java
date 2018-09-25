package me.cxy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.cxy.tailer.Tailer;
import me.cxy.tailer.deliver.Deliver;
import me.cxy.tailer.deliver.impl.SimpleDeliver;

@SpringBootApplication
public class TailerDemo{

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TailerDemo.class);
		app.run(args);
	}
	
	@Bean
	public Tailer createTailer() {
		return new Tailer(createDeliver());
	}
	
	@Bean
	public Deliver createDeliver() {
		return new SimpleDeliver();
	}
	
}
