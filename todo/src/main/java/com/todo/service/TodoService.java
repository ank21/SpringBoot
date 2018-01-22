package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;


@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	
	public void insert(Todo todo) {
		todoRepository.save(todo);
	}
	
	public List<Todo> findbytype(String type){
		return todoRepository.findByTodoType(type);
	}
	

}
