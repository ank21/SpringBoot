package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.model.TodoItem;
import com.todo.repository.TodoItemRepository;
import com.todo.repository.TodoRepository;


@Service
public class TodoService {

	@Autowired 
	TodoItemRepository todoRepository;
	
	public List<TodoItem> getalltodo(){
		return todoRepository.findAll();
	}
	
	public void inserttodo(TodoItem todoItem) {
		todoRepository.save(todoItem);
	}
}
