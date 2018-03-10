package com.stock.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@Column(name="symbol")
	private String symbol;
	@Column(name="name")
	private String cname;
	@Column(name="market_cap")
	private Double marketcap;
	@Column(name="sector")
	private String sector;
	@Column(name="industry")
	private String industry;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Double getMarketcap() {
		return marketcap;
	}
	public void setMarketcap(Double marketcap) {
		this.marketcap = marketcap;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
}
