package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.Company;
import com.stock.repository.CompanyRepo;

@RestController
public class DataController {

	
	@Autowired
	CompanyRepo crepo;
	
	@GetMapping("/company")
	List<Company> getCompany(@RequestParam("cname") String name){
		return crepo.getByCname(name);
	}
}
