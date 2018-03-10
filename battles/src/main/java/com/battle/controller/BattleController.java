package com.battle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BattleController {

	
	@RequestMapping("/battle")
	String battle() {
		return "battle";
	}
	
	@RequestMapping("/king")
	String king() {
		return "king";
	}
}
