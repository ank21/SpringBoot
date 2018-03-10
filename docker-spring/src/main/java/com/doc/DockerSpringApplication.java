package com.doc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doc.model.Employee;
import com.doc.repository.EmpRepository;

@SpringBootApplication
public class DockerSpringApplication implements CommandLineRunner{

	@Autowired
	EmpRepository emprepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DockerSpringApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		List<Employee> elist=new ArrayList<>();
		Employee emp1=new Employee("Soumyajit Das","BIW Fixture Designer");
		Employee emp2=new Employee("Rajesh Das","BM");
		Employee emp3=new Employee("Ankit Anubhav","Software Engineer");
		elist.add(emp1);
		elist.add(emp2);
		elist.add(emp3);
		emprepo.save(elist);
	}
}
