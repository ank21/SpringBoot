package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.todo.model.Todo;



@Repository
public interface TodoRepository extends JpaRepository<Todo,String>{
	
	List<Todo> findByTodoType(String type);
	
	
	
	
}
