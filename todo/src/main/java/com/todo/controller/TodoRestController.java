package com.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.todo.model.Todo;
import com.todo.model.TodoItem;
import com.todo.service.TodoItemService;
import com.todo.service.TodoService;

@RestController
public class TodoRestController {

	@Autowired
	TodoItemService todoitemService;

	@Autowired
	TodoService todoService;

	@PostMapping("/pdata")
	void insert(@RequestBody TodoItem todoItem) {
		Todo todo = null;
		String tododate = todoItem.getTodoDate();
		if (todoitemService.findby(tododate).isEmpty() || todoitemService.findby(tododate) == null) {
			todoitemService.inserttodo(todoItem);
			todo = todoItem.getTodoList().get(0);
			todo.setTodoItem(todoItem);
			todoService.insert(todo);
		} else {

			TodoItem f = todoitemService.findby(tododate).get(0);
			todo = todoItem.getTodoList().get(0);
			todo.setTodoItem(f);

			todoService.insert(todo);
		}

	}

	@GetMapping("/get/{fil}")
	List<TodoItem> find(@PathVariable String fil) {

		List<Todo> st = null;
		List<TodoItem> lt = new ArrayList<>();
		if (!fil.equals("normal")) {
			List<Todo> todoList = todoService.findbytype(fil);

			TodoItem todoitem = null;
			for (Todo t : todoList) {
				st = new ArrayList<>();
				todoitem = new TodoItem();
				todoitem.setTodoDate(t.getTodoItem().getTodoDate());
				st.add(t);
				todoitem.setTodoList(st);
				lt.add(todoitem);
			}

		} else {
			lt = todoitemService.get();
		}
		return lt;

	}
}
