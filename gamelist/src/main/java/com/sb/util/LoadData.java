package com.sb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class LoadData implements CommandLineRunner {

	@Autowired
	Parser parse;
	
	@Override
	public void run(String... arg0) throws Exception {
		parse.csvReader();
		
	}

}
