package com.desafios.accounts.controller;

import com.desafios.accounts.model.TransferDTO;
import com.desafios.accounts.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/transfers")
public class TransferController {

    private TransferService transferService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<TransferDTO> createTransfer(@RequestBody TransferDTO transferDTO) {
        var tranfer = transferService.createTransfer(transferDTO);
        return new ResponseEntity<>(tranfer, HttpStatus.CREATED);
    }
}
