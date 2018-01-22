package com.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.service.TodoItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TodoController {

	@Autowired
	TodoItemService to;
	
	
	@RequestMapping("/")
	String index() {
		
		return "index";
	}

}
