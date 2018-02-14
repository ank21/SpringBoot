package com.sb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sb.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	Page<Game> findAll(Pageable page);
	List<Game> findAllByOrderByScoreAsc(Pageable page);
	List<Game> findByPlatform(String s);
	 List<Game> findAll(Sort s);
	List<Game> findByPlatform(String s,Sort st);
}
