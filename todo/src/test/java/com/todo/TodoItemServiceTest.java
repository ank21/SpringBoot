package com.todo;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Todo;
import com.todo.repository.TodoItemRepository;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;

public class TodoItemServiceTest {
	
	
	
	@Autowired 
	TodoRepository todoRepository;
	@Test
	public void getTest() {
		List<Todo> todoList = todoRepository.findByTodoType("Work");
		if(todoList.size()<0)
			fail("no items in the list");
	}

}
