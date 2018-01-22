package com.todo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Todo;
import com.todo.model.TodoItem;



@Repository
public interface TodoRepository extends MongoRepository<Todo,String>{
	
	
	
	
}
