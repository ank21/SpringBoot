package com.battle.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.battle.model.Battle;
import com.battle.model.King;
import com.battle.repository.BattleRepository;
import com.battle.repository.KingRepository;

@Service
public class BattleService {

	@Autowired
	BattleRepository battleRepo;
	
	
	@Autowired
	KingRepository kingRepo;

	double R1, R2, r1, r2, e1, e2, s1, s2;
	String at_name;
	String df_name;
	King attacker_king;
	King defender_king;

	/*This method will create all the kings details from the battles table*/
	public void buildKings() {
		List<Battle> blist = battleRepo.findAll();
		Map<String, King> map = new HashMap<>();
		Set<String> attacker = blist.stream().map(Battle::getAttacker_king).collect(Collectors.toSet());//get all the attacker kings name
		Set<String> defender = blist.stream().map(Battle::getdefender_king).collect(Collectors.toSet());//get all the defender kings name
		
		Set<String> to = new HashSet<>(attacker);
		to.addAll(defender);
		
		for (Battle b : blist) {

			at_name = b.getAttacker_king(); //to get attacker king name
			df_name = b.getdefender_king(); //to get defender king name

			if (b.getAttacker_king().equals("") || b.getdefender_king().equals(""))
				continue;

			if (map.containsKey(b.getAttacker_king())) {
				attacker_king = map.get(at_name);
				s1 = b.getAttacker_outcome().equals("win") ? 1 : 0;
				r1 = attacker_king.getRatting();
			} else {
				
				attacker_king = new King();
				attacker_king.setName(at_name);
				attacker_king.setBattle_lose(0);
				attacker_king.setBattle_won(0);
				r1 = 400;
				s1 = b.getAttacker_outcome().equals("win") ? 1 : 0;
			}

			if (map.containsKey(df_name)) {
				defender_king = map.get(df_name);
				s2 = b.getAttacker_outcome().equals("win") ? 0 : 1;
				r2 = defender_king.getRatting();
			} else {
				defender_king = new King();
				defender_king.setName(df_name);
				defender_king.setBattle_lose(0);
				defender_king.setBattle_won(0);
				r2 = 400;
				s2 = b.getAttacker_outcome().equals("win") ? 0 : 1;
			}

			compute_rate(r1, r2, s1, s2);
			attacker_king.setRatting(r1);
			defender_king.setRatting(r2);
			map.put(at_name, attacker_king);
			map.put(df_name, defender_king);
			
		}

		for(Map.Entry<String,King> entry: map.entrySet()) {
			
			kingRepo.save(entry.getValue());
		}

	}

	/**
	   * This method is used to compute the Elo Rating System
	   * @param r1 ratting of attacker
	   * @param r2 ratting of defender
	   * @param s1 to represent attacker win/loss
	   * @param s2 to represent defender win/loss
	   */
	
	private void compute_rate(double r1, double r2, double s1, double s2) {

		if (s1 == 1)
			attacker_king.setBattle_won(attacker_king.getBattle_won() + 1);
		else
			attacker_king.setBattle_lose(attacker_king.getBattle_lose() + 1);
		if (s2 == 1)
			defender_king.setBattle_won(defender_king.getBattle_won() + 1);
		else
			defender_king.setBattle_lose(defender_king.getBattle_lose() + 1);

		double R1, R2, E1, E2;
		R1 = Math.pow(10.0, (r1 / 400));
		R2 = Math.pow(10.0, (r1 / 400));
		E1 = R1 / (R1 + R2);
		E2 = R2 / (R1 + R2);
		this.r1 = r1 + 32 * (s1 - E1);
		this.r2 = r2 + 32 * (s2 - E2);
	}

}
