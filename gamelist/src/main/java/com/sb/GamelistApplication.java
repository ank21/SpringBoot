package com.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.util.Parser;

@SpringBootApplication
public class GamelistApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GamelistApplication.class, args);
	}
	@Autowired
	Parser parse;
	
	@Override
	public void run(String... arg0) throws Exception {
		parse.csvReader();
		
	}
}
