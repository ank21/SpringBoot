package com.todo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.todo.model.TodoItem;


@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,String>{

	List<TodoItem> findByTodoDate(String dt);
}
