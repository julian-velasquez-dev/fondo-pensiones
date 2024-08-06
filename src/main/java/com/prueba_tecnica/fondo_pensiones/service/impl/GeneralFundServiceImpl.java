package com.prueba_tecnica.fondo_pensiones.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba_tecnica.fondo_pensiones.model.Client;
import com.prueba_tecnica.fondo_pensiones.model.Fund;
import com.prueba_tecnica.fondo_pensiones.model.GeneralFund;
import com.prueba_tecnica.fondo_pensiones.model.Transaction;
import com.prueba_tecnica.fondo_pensiones.repository.ClientRepository;
import com.prueba_tecnica.fondo_pensiones.repository.GeneralFundRepository;
import com.prueba_tecnica.fondo_pensiones.service.GeneralFundService;

/**
 * Service class for managing clients 
 */
@Service
public class GeneralFundServiceImpl implements GeneralFundService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private GeneralFundRepository generalFundRepository;
	
	@Override
	public Client subscribeToFund(String clientId, String fundId, String notification) throws Exception {
	    try {
	        // Find the client by their ID
	        Client client = clientRepository.findByClientId(clientId)
	                .orElseThrow(() -> new Exception("Client not found"));

	        // Find the fund by its ID
	        GeneralFund generalFund = generalFundRepository.findByFundId(fundId)
	                .orElseThrow(() -> new Exception("Fund not found"));

	        // Check if the client is already subscribed to the fund
	        if (client.getFunds().stream().anyMatch(f -> f.getFundId().equals(fundId))) {
	            throw new Exception("Already subscribed to this fund");
	        }

	        // Check if the client has sufficient balance to subscribe to the fund
	        if (client.getBalance().compareTo(generalFund.getMinimumAmount()) < 0) {
	            throw new Exception("Insufficient balance to subscribe to fund " + generalFund.getName());
	        }

	        // Create a new fund subscription for the client
	        Fund fund = new Fund(fundId, generalFund.getName(), generalFund.getCategory(), generalFund.getMinimumAmount());
	        client.getFunds().add(fund);

	        // Deduct the subscription amount from the client's balance
	        client.setBalance(client.getBalance().subtract(generalFund.getMinimumAmount()));

	        // Create a new transaction for the subscription
	        Transaction transaction = new Transaction(
	            UUID.randomUUID().toString(), 
	            "subscription", 
	            fundId, 
	            generalFund.getName(), 
	            generalFund.getMinimumAmount(), 
	            new Date(), 
	            notification
	        );
	        client.getTransactions().add(transaction);

	        // Save the updated client entity in the repository
	        return clientRepository.save(client);

	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	        // Rethrow the exception to indicate failure
	        throw new Exception("Failed to subscribe to fund: " + e.getMessage(), e);
	    }
	}


	@Override
	public Client cancelFund(String clientId, String fundId) throws Exception {
		// Find the client by their ID
	    Client client = clientRepository.findByClientId(clientId)
	            .orElseThrow(() -> new Exception("Client not found"));

	    // Find the subscribed fund by its ID
	    Fund fund = client.getFunds().stream()
	            .filter(f -> f.getFundId().equals(fundId))
	            .findFirst()
	            .orElseThrow(() -> new Exception("Not subscribed to this fund"));

	    // Remove the fund from the client's subscription list
	    client.getFunds().remove(fund);

	    // Create a new transaction for the cancellation
	    Transaction transaction = new Transaction(UUID.randomUUID().toString(), "cancellation", fundId, fund.getName(), fund.getAmount(), new Date(), null);
	    client.getTransactions().add(transaction);

	    // Save the updated client entity in the repository
	    return clientRepository.save(client);
	}

	@Override
	public List<Transaction> viewTransactionHistory(String clientId) throws Exception {
		
		// Find the client by their ID
	    Client client = clientRepository.findByClientId(clientId)
	            .orElseThrow(() -> new Exception("Client not found"));

	    // Return the list of transactions made by the client
	    return client.getTransactions();
	}
	
}
