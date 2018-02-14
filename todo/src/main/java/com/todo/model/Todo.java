package com.todo.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Todo {

	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer todoId;
	private String taskName;
	private Date dueDate;
	private String status;
	private String todoType;

	@ManyToOne
	@JoinColumn(name = "todoItemId",nullable=true)
	@JsonIgnore
	private TodoItem todoItem;

	public String getTodoType() {
		return todoType;
	}

	public void setTodoType(String todoType) {
		this.todoType = todoType;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public TodoItem getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(TodoItem todoItem) {
		this.todoItem = todoItem;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", taskName=" + taskName + ", dueDate=" + dueDate + ", status=" + status
				+  "]";
	}

	

}
