package com.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doc.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
