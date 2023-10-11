package com.desafios.transfers.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    @PostMapping(value = "/transfer", produces = "application/json")
    public String createTransfer() {
        return "";
    }

}
