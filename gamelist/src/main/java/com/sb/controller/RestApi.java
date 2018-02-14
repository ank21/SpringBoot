package com.sb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Game;
import com.sb.repository.GameRepository;

@RestController
public class RestApi {

	@Autowired
	GameRepository gamerepo;
	
	@GetMapping("/get")
	List<Game> getdata(@RequestParam("sort") String s,@RequestParam("fkey") String filter) {
		
		List<Game> gamelist=new ArrayList<>();
		
		if(filter.equals("none") && s.equals("none"))
		gamelist=gamerepo.findAll();
		else if(filter.equals(filter) && s.equals("none") )
		gamelist=gamerepo.findByPlatform(filter);
		else
		{
			if(s.equals("ascending")) {
			Sort sort1 = new Sort(Direction.ASC, "score");
			if(filter.equals("none"))
				gamelist=gamerepo.findAll(sort1);
			else
			gamelist=gamerepo.findByPlatform(filter, sort1);
			}
			else {
			Sort sort2 = new Sort(Direction.DESC, "score");
			if(filter.equals("none"))
				gamelist=gamerepo.findAll(sort2);
			else
			gamelist=gamerepo.findByPlatform(filter, sort2);
			}
		}
		return gamelist;
	}
	
}
