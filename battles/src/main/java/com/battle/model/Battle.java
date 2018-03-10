package com.battle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="battles")
public class Battle {
	
	
	@Id
	@Column(name="battle_number")
	Integer battle_number;
	@Column(name="name")
	String name;
	@Column(name="year")
	Integer year;
	
	@Column(name="attacker_king")
	String attacker_king;
	@Column(name="defender_king")
	String defender_king;
	@Column(name="attacker_1")
	String attacker_1;
	@Column(name="attacker_2")
	String attacker_2;
	@Column(name="attacker_3")
	String attacker_3;
	@Column(name="attacker_4")
	String attacker_4;
	@Column(name="defender_1")
	String defender_1;
	@Column(name="defender_2")
	String defender_2;
	@Column(name="defender_3")
	String defender_3;
	@Column(name="defender_4")
	String defender_4;
	@Column(name="attacker_outcome")
	String attacker_outcome;
	@Column(name="battle_type")
	String battle_type;
	@Column(name="major_death")
	String major_death;
	@Column(name="major_capture")
	String major_capture;
	@Column(name="attacker_size")
	String attacker_size;
	@Column(name="defender_size")
	String defeder_size;
	@Column(name="attacker_commander")
	String attacker_commander;
	@Column(name="defender_commander")
	String defender_comander;
	@Column(name="summer")
	String summer;
	@Column(name="location")
	String location;
	@Column(name="region")
	String region;
	@Column(name="note")
	String note;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getBattle_number() {
		return battle_number;
	}
	public void setBattle_number(Integer battle_number) {
		this.battle_number = battle_number;
	}
	public String getAttacker_king() {
		return attacker_king;
	}
	public void setAttacker_king(String attacker_king) {
		this.attacker_king = attacker_king;
	}
	public String getdefender_king() {
		return defender_king;
	}
	public void setdefender_king(String defender_king) {
		this.defender_king = defender_king;
	}
	public String getAttacker_1() {
		return attacker_1;
	}
	public void setAttacker_1(String attacker_1) {
		this.attacker_1 = attacker_1;
	}
	public String getAttacker_2() {
		return attacker_2;
	}
	public void setAttacker_2(String attacker_2) {
		this.attacker_2 = attacker_2;
	}
	public String getAttacker_3() {
		return attacker_3;
	}
	public void setAttacker_3(String attacker_3) {
		this.attacker_3 = attacker_3;
	}
	public String getAttacker_4() {
		return attacker_4;
	}
	public void setAttacker_4(String attacker_4) {
		this.attacker_4 = attacker_4;
	}
	public String getDefender_1() {
		return defender_1;
	}
	public void setDefender_1(String defender_1) {
		this.defender_1 = defender_1;
	}
	public String getDefender_2() {
		return defender_2;
	}
	public void setDefender_2(String defender_2) {
		this.defender_2 = defender_2;
	}
	public String getDefender_3() {
		return defender_3;
	}
	public void setDefender_3(String defender_3) {
		this.defender_3 = defender_3;
	}
	public String getDefender_4() {
		return defender_4;
	}
	public void setDefender_4(String defender_4) {
		this.defender_4 = defender_4;
	}
	public String getAttacker_outcome() {
		return attacker_outcome;
	}
	public void setAttacker_outcome(String attacker_outcome) {
		this.attacker_outcome = attacker_outcome;
	}
	public String getBattle_type() {
		return battle_type;
	}
	public void setBattle_type(String battle_type) {
		this.battle_type = battle_type;
	}
	public String getMajor_death() {
		return major_death;
	}
	public void setMajor_death(String major_death) {
		this.major_death = major_death;
	}
	public String getMajor_capture() {
		return major_capture;
	}
	public void setMajor_capture(String major_capture) {
		this.major_capture = major_capture;
	}
	public String getAttacker_size() {
		return attacker_size;
	}
	public void setAttacker_size(String attacker_size) {
		this.attacker_size = attacker_size;
	}
	public String getDefeder_size() {
		return defeder_size;
	}
	public void setDefeder_size(String defeder_size) {
		this.defeder_size = defeder_size;
	}
	public String getAttacker_commander() {
		return attacker_commander;
	}
	public void setAttacker_commander(String attacker_commander) {
		this.attacker_commander = attacker_commander;
	}
	public String getDefender_comander() {
		return defender_comander;
	}
	public void setDefender_comander(String defender_comander) {
		this.defender_comander = defender_comander;
	}
	public String getSummer() {
		return summer;
	}
	public void setSummer(String summer) {
		this.summer = summer;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	

}
