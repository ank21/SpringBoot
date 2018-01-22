package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.model.TodoItem;
import com.todo.service.TodoService;

@RestController
public class TodoRestController {

	@Autowired
	TodoService todoService;
	
	
	@RequestMapping("/pdata")
	void insert(@RequestBody TodoItem todoItem) {
		
		todoService.inserttodo(todoItem);
		System.out.println("inserting-------"+todoItem);
		
	}

	
	
	@GetMapping("/get")
	List<TodoItem> find() {
		List<TodoItem> li=todoService.getalltodo();
		
		return li;
	}
}
