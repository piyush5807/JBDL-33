package com.example.minor1.controllers;

import com.example.minor1.services.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TxnService txnService;

    @PostMapping("/transaction/issue")
    public void issueTxn(){
        txnService.issueTxn();
    }
}
