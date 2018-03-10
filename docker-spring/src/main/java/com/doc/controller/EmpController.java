package com.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.model.Employee;
import com.doc.repository.EmpRepository;

@RestController
public class EmpController {

	@Autowired
	EmpRepository emprepo;
	
	
	@GetMapping("/list")
	List<Employee> getEmp(){
		return emprepo.findAll();
	}
}
