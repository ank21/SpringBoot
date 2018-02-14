package com.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.model.Todo;



@Repository
public interface TodoRepository extends JpaRepository<Todo,String>{
	
	List<Todo> findByTodoType(String type);
	
	@Modifying
	@Transactional
	@Query("update Todo u set u.status= ?2 where u.taskName= ?1")
	void update(String task,String status);
	
	
	
	
}
