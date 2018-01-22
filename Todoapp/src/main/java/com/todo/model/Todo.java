package com.todo.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



public class Todo {

	private String Id;
	private String taskName;
	private String dueDate;
	private String status;
	private String todoType;
	



	public String getTodoType() {
		return todoType;
	}

	public void setTodoType(String todoType) {
		this.todoType = todoType;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}



	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "Todo [Id=" + Id + ", taskName=" + taskName + ", dueDate=" + dueDate + ", status=" + status
				  +"]";
	}
	
	
	
}
