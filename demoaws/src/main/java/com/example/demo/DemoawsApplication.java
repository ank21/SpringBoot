package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("com.example.demo.controller")

public class DemoawsApplication {
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(DemoawsApplication.class, args);
	}
}
