package com.battle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.battle.model.Battle;


@Repository
public interface BattleRepository extends JpaRepository<Battle,Integer> {
	
	@Query("select b from Battle b where b.battle_type=:s")
	List<Battle> findAllBy(@Param("s")String s);

}
