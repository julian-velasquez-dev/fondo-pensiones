package com.prueba_tecnica.fondo_pensiones.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a transaction made by a client.
 */
public class Transaction {
	
	/**
	 * The unique identifier for the transaction.
	 */
	private String transactionId;
	
	/**
	 * The type of transaction.
	 */
	private String type;
	
	/**
	 * The unique identifier for the fund involved in the transaction.
	 */
	private String fundId;
	
	/**
	 * The name of the fund involved in the transaction.
	 */
	private String foundName;
	
	/**
	 * The amount of the fund involved in the transaction.
	 */
	private BigDecimal amount;
	
	/**
	 * The date of the transaction.
	 */
	private Date date;
	
	/**
	 * The notification method for the transaction.
	 */
	private String modification;

	public Transaction(String transactionId, String type, String fundId, String foundName, BigDecimal amount, Date date,
			String modification) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.fundId = fundId;
		this.foundName = foundName;
		this.amount = amount;
		this.date = date;
		this.modification = modification;
	}
	
	public Transaction() {
		
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getFoundName() {
		return foundName;
	}

	public void setFoundName(String foundName) {
		this.foundName = foundName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getModification() {
		return modification;
	}

	public void setModification(String modification) {
		this.modification = modification;
	}
}
