package com.prueba_tecnica.fondo_pensiones.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a client stored in the clients collection MongoDB.
 */
@Document(collection = "clients")
public class Client {
	
	/**
	 * The unique identifier for the client, mapped to MongoDB's _id.
	 */
	@Id
	private String id;
	
	/**
	 * The unique identifier for the client used in queries and operations.
	 */
	private String clientId;
	
	/**
	 * The name of the client.
	 */
	private String name;
	
	/**
	 * The address of the client.
	 */
	private String address;
	
	/**
     * The balance of the client.
     */
    private BigDecimal balance;
	
	/**
	 * The list of funds associated with the client.
	 */
	private List<Fund> funds = new ArrayList<>();
	
	/**
	 * The list of the transaction made by the client.
	 */
	private List<Transaction> transactions = new ArrayList<>();
	
	public Client(String id, String clientId, String name, String address, BigDecimal balance, List<Fund> funds,
            List<Transaction> transactions) {
	  this.id = id;
	  this.clientId = clientId;
	  this.name = name;
	  this.address = address;
	  this.balance = balance;
	  this.funds = funds != null ? funds : new ArrayList<>();
	  this.transactions = transactions != null ? transactions : new ArrayList<>();
	}

	public Client() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
