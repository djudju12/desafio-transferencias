package com.desafios.accounts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    @PostMapping(produces = "application/json")
    public String createTransfer() {
        return "transfer";
    }
}
