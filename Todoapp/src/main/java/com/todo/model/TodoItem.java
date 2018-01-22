package com.todo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;



@Document
public class TodoItem {
	
	@Id
	private String id;
	
	
	private List<Todo> todoList;
	
	private String todoDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}

	public String getTodoDate() {
		return todoDate;
	}

	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", todoList=" + todoList + ", todoDate=" + todoDate + "]";
	}
	
}
