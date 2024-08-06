package com.prueba_tecnica.fondo_pensiones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba_tecnica.fondo_pensiones.model.Client;
import com.prueba_tecnica.fondo_pensiones.model.Transaction;
import com.prueba_tecnica.fondo_pensiones.service.GeneralFundService;

@RestController
@RequestMapping("/api/funds")
public class GeneralFundController {
	
	@Autowired
    private GeneralFundService generalFundService;

    @PostMapping("/subscribe")
    public ResponseEntity<Client> subscribeToFund(@RequestParam String clientId, @RequestParam String fundId, @RequestParam String notification) {
        try {
            Client client = generalFundService.subscribeToFund(clientId, fundId, notification);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<Client> cancelFund(@RequestParam String clientId, @RequestParam String fundId) {
        try {
            Client client = generalFundService.cancelFund(clientId, fundId);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> viewTransactionHistory(@RequestParam String clientId) {
        try {
            List<Transaction> transactions = generalFundService.viewTransactionHistory(clientId);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
