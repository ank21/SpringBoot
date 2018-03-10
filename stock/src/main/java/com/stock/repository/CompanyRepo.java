package com.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Company;

public interface CompanyRepo extends JpaRepository<Company,String> {
	
	
	List<Company> getByCname(String s);

}
