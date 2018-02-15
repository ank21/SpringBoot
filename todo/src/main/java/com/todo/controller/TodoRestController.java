package com.todo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.model.TodoItem;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoItemService;
import com.todo.service.TodoService;

@RestController
public class TodoRestController {

	@Autowired
	TodoRepository todorepo;

	@Autowired
	TodoItemService todoitemService;

	@Autowired
	TodoService todoService;

	
	/* 
	 * This rest api is used to get all the data stored in data base while loading 
	 * the page initially
	 * 
	 * */
	@PostMapping("/pdata")
	void insert(@RequestBody TodoItem todoItem) {
		Todo todo = null;
		Date tododate = todoItem.getTodoDate();
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

	
	
	/* 
	 * This rest api is used to store the data coming from
	 * client side as json and returns the updated data
	 * 
	 * It takes the parameter fil to filter the data
	 * 
	 * */
	@GetMapping("/get")
	List<TodoItem> find(@RequestParam("filter") String fil) {

		List<TodoItem> lt = new ArrayList<>();
		if (!fil.equals("normal")) {
			List<Todo> todoList = todoService.findbytype(fil);
			Set<Date> todol = todoList.stream().map(x -> x.getTodoItem().getTodoDate()).collect(Collectors.toSet());

			for (Date d : todol) {
				List<Todo> st = new ArrayList<>();
				TodoItem todoitem = new TodoItem();
				todoitem.setTodoDate(d);
				for (Todo s : todoList) {
					if (d.equals(s.getTodoItem().getTodoDate())) {
						st.add(s);
					}
				}
				todoitem.setTodoList(st);
				lt.add(todoitem);
			}

		}

		else {
			lt = todoitemService.get();
		}
		return lt;

	}
	
	
	@GetMapping("/update")
	void update(@RequestParam("id") Integer id,@RequestParam("value") String value){
		System.out.println("got he request"+id+value);
		todorepo.update(id, value);
	}

}
