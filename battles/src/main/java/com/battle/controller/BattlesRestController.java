package com.battle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.battle.model.Battle;
import com.battle.model.King;
import com.battle.repository.BattleRepository;
import com.battle.repository.KingRepository;
import com.battle.service.BattleService;


@RestController
public class BattlesRestController {

	@Autowired
	BattleRepository battleRepo;
	
	
	@Autowired
	KingRepository kingRepo;
	
	@Autowired
	BattleService bs;

	
	/**
	   * This method is used to call the rest api /battlelist  from frontend
	   * it will return all the battle details in the form of json
	   * @param filter to filter the battle list accordint to battleType 
	   * @return json This returns battlelist as json.
	   */

	@GetMapping("/battlelist")
	List<Battle> get(@RequestParam("filter")String filter) {
		bs.buildKings() ;
		
		List<Battle> blist;
		if(filter.equals("none"))
		blist=battleRepo.findAll();
		else
		{
			blist=battleRepo.findAllBy(filter);
			System.out.println("in else====="+blist);
		}
		return blist;
		
	}
	
	/**
	   * This method is used to call the rest api /kinglist  from frontend
	   * it will return all the kings details in the form of json 
	   * @return json This returns kingsist as json.
	   */
	
	@GetMapping("/kingslist")
	List<King> getKings(){
		return kingRepo.findAllByOrderByRattingDesc();
		}
	
	
	/**
	   * This method is used to call the rest api /findking from frontend
	   * it will return the kings details in the form of json 
	   * @param king  This is the king name whose details has to send
	   * @return json This returns kings deatil as json.
	   */
	@RequestMapping("/findking")
	public @ResponseBody King getKing(@RequestParam("king") String king) {
		
		King k=kingRepo.getOne(king);
		System.out.println(k);
		return k;
		
	}
}
