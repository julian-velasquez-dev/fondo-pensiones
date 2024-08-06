package com.prueba_tecnica.fondo_pensiones.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prueba_tecnica.fondo_pensiones.model.Client;
import com.prueba_tecnica.fondo_pensiones.model.Fund;
import com.prueba_tecnica.fondo_pensiones.model.GeneralFund;
import com.prueba_tecnica.fondo_pensiones.model.Transaction;
import com.prueba_tecnica.fondo_pensiones.repository.ClientRepository;
import com.prueba_tecnica.fondo_pensiones.repository.GeneralFundRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Collections;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GeneralFundServiceImplTest {

    @InjectMocks
    private GeneralFundServiceImpl generalFundService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private GeneralFundRepository generalFundRepository;

    /** Initialize mocks before each test **/
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCancelFund() throws Exception {
        String clientId = "client123";
        String fundId = "fund123";

        // Create a mock client with a fund subscription
        Client client = new Client();
        client.setClientId(clientId);
        client.setFunds(new ArrayList<>());
        Fund fund = new Fund(fundId, "Fund Name", "Category", new BigDecimal("100.00"));
        client.getFunds().add(fund);

        // Mock repository response
        when(clientRepository.findByClientId(clientId)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method
        Client updatedClient = generalFundService.cancelFund(clientId, fundId);

        // Assert that the updated client is not null
        assertNotNull(updatedClient);

        // Assert that the fund has been removed from the client's list of funds
        assertTrue(updatedClient.getFunds().stream().noneMatch(f -> f.getFundId().equals(fundId)));

        // Assert that the transaction list has been updated
        assertFalse(updatedClient.getTransactions().isEmpty());
        assertEquals("cancellation", updatedClient.getTransactions().get(0).getType());
    }

    @Test
    void testViewTransactionHistory() throws Exception {
        String clientId = "client123";

        /** Create a mock client with a list of transactions **/
        Client client = new Client();
        client.setClientId(clientId);

        Transaction transaction = new Transaction(UUID.randomUUID().toString(), "type", "fundId", "fundName", new BigDecimal("100.00"), new Date(), "notification");
        client.setTransactions(new ArrayList<>(Collections.singletonList(transaction)));

        when(clientRepository.findByClientId(clientId)).thenReturn(Optional.of(client));

        /** Call the service method and verify the response **/
        List<Transaction> transactions = generalFundService.viewTransactionHistory(clientId);

        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }
}
