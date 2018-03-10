package com.battle.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class King implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6890649021421434648L;
	/** 
	 * 
	 */
	
	@Id
	String name;
	Integer battle_won;
	Integer battle_lose;
	Double ratting;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBattle_won() {
		return battle_won;
	}
	public void setBattle_won(Integer battle_won) {
		this.battle_won = battle_won;
	}
	public Integer getBattle_lose() {
		return battle_lose;
	}
	public void setBattle_lose(Integer battle_lose) {
		this.battle_lose = battle_lose;
	}
	public Double getRatting() {
		return ratting;
	}
	public void setRatting(Double ratting) {
		this.ratting = ratting;
	}
	@Override
	public String toString() {
		return "King [name=" + name + ", battle_won=" + battle_won + ", battle_lose=" + battle_lose + ", ratting="
				+ ratting + "]";
	}
	
}
