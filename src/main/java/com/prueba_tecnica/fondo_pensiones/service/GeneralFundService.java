package com.prueba_tecnica.fondo_pensiones.service;

import java.util.List;

import com.prueba_tecnica.fondo_pensiones.model.Client;
import com.prueba_tecnica.fondo_pensiones.model.Transaction;

public interface GeneralFundService {
	
	/**
     * Subscribes a client to a specified fund.
     * @param clientId     The ID of the client who wants to subscribe.
     * @param fundId       The ID of the fund to subscribe to.
     * @param notification The type of notification to send ("email" or "sms").
     * @return The updated client entity after subscription.
     * @throws Exception if there are any issues during the subscription process.
     */
	public Client subscribeToFund(String clientId, String fundId, String notification) throws Exception;
	
	/**
	 * Cancels a fund subscription for a client.
	 * @param clientId The ID of the client who wants to cancel the subscription.
	 * @param fundId   The ID of the fund to cancel.
	 * @return The updated client entity after the cancellation.
	 * @throws Exception if there are any issues during the cancellation process, such as client or fund not found.
	 */
	public Client cancelFund(String clientId, String fundId) throws Exception;
	
	/**
	 * Retrieves the transaction history for a client.
	 * @param clientId The ID of the client whose transaction history is to be retrieved.
	 * @return A list of transactions made by the client.
	 * @throws Exception if the client is not found.
	 */
	public List<Transaction> viewTransactionHistory(String clientId) throws Exception;
}
