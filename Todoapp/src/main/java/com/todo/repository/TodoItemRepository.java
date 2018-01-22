package com.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.model.TodoItem;

public interface TodoItemRepository extends MongoRepository<TodoItem,String>{

	
}
