package com.battle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.battle.model.King;

@Repository
public interface KingRepository extends JpaRepository<King, String> {

	List<King> findAllByOrderByRattingDesc();
}
