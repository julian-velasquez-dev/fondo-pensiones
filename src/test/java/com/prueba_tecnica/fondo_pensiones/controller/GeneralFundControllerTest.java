package com.prueba_tecnica.fondo_pensiones.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.prueba_tecnica.fondo_pensiones.model.Client;
import com.prueba_tecnica.fondo_pensiones.model.Transaction;
import com.prueba_tecnica.fondo_pensiones.service.GeneralFundService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

class GeneralFundControllerTest {

    @InjectMocks
    private GeneralFundController generalFundController;

    @Mock
    private GeneralFundService generalFundService;

    /** Initialize mocks **/
    public GeneralFundControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubscribeToFund() throws Exception {
        String clientId = "client123";
        String fundId = "fund123";
        String notification = "Subscribed successfully";

        /** Create a mock client **/
        Client client = new Client();
        when(generalFundService.subscribeToFund(clientId, fundId, notification)).thenReturn(client);

        /** Call the controller method and verify the response **/
        ResponseEntity<Client> response = generalFundController.subscribeToFund(clientId, fundId, notification);

        assertEquals(OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    public void testSubscribeToFund_Exception() throws Exception {
        String clientId = "client123";
        String fundId = "fund123";
        String notification = "Subscribed successfully";

        /** Simulate an exception in the service **/
        when(generalFundService.subscribeToFund(clientId, fundId, notification)).thenThrow(new Exception("Error"));

        /** Call the controller method and verify the response **/
        ResponseEntity<Client> response = generalFundController.subscribeToFund(clientId, fundId, notification);

        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testCancelFund() throws Exception {
        String clientId = "client123";
        String fundId = "fund123";

        /** Create a mock client **/
        Client client = new Client();
        when(generalFundService.cancelFund(clientId, fundId)).thenReturn(client);

        /** Call the controller method and verify the response **/
        ResponseEntity<Client> response = generalFundController.cancelFund(clientId, fundId);

        assertEquals(OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    public void testCancelFund_Exception() throws Exception {
        String clientId = "client123";
        String fundId = "fund123";

        /** Simulate an exception in the service **/
        when(generalFundService.cancelFund(clientId, fundId)).thenThrow(new Exception("Error"));

        /** Call the controller method and verify the response **/
        ResponseEntity<Client> response = generalFundController.cancelFund(clientId, fundId);

        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testViewTransactionHistory() throws Exception {
        String clientId = "client123";

        /** Create a mock list of transactions **/
        List<Transaction> transactions = List.of(new Transaction());
        when(generalFundService.viewTransactionHistory(clientId)).thenReturn(transactions);

        /** Call the controller method and verify the response **/
        ResponseEntity<List<Transaction>> response = generalFundController.viewTransactionHistory(clientId);

        assertEquals(OK, response.getStatusCode());
        assertEquals(transactions, response.getBody());
    }

    @Test
    public void testViewTransactionHistory_Exception() throws Exception {
        String clientId = "client123";

        /** Simulate an exception in the service **/
        when(generalFundService.viewTransactionHistory(clientId)).thenThrow(new Exception("Error"));

        /** Call the controller method and verify the response **/
        ResponseEntity<List<Transaction>> response = generalFundController.viewTransactionHistory(clientId);

        assertEquals(BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}

