package com.prueba_tecnica.fondo_pensiones.model;

import java.math.BigDecimal;

/**
 * Represent a fund entity associated with a client.
 */
public class Fund {
	
	/**
	 * The unique identifier for the found.
	 */
	private String fundId;
	
	/**
	 * The name of the found. 
	 */
	private String name;
	
	/**
	 * The category of the fund.
	 */
	private String category;
	
	/**
	 * The amount invested in the fund.
	 */
	private BigDecimal amount;

	public Fund(String fundId, String name, String category, BigDecimal amount) {
		super();
		this.fundId = fundId;
		this.name = name;
		this.category = category;
		this.amount = amount;
	}
	
	public Fund() {
		
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
