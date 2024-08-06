package com.prueba_tecnica.fondo_pensiones.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a general fund entity stored in the "funds" collections in MongoDB.
 */
@Document(collection = "funds")
public class GeneralFund {
	
	/**
	 * The unique identifier for the fund, mapped to MongoDB's _id.
	 */
	@Id
	private String id;
	
	/**
	 * The unique identifier for the fund used in queries and operations.
	 */
	private String fundId;
	
	/**
	 * The name of the fund.
	 */
	private String name;
	
	/**
	 * The minimum amount required to invest in the fund.
	 */
	private BigDecimal minimumAmount;
	
	/**
	 * The category of the fund.
	 */
	private String category;

	public GeneralFund(String fundId, String name, BigDecimal minimumAmount, String category) {
		super();
		this.fundId = fundId;
		this.name = name;
		this.minimumAmount = minimumAmount;
		this.category = category;
	}
	
	public GeneralFund() {
		
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

	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(BigDecimal minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
