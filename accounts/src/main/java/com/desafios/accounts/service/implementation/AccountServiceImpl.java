package com.desafios.accounts.service.implementation;

import com.desafios.accounts.model.Account;
import com.desafios.accounts.model.AccountDTO;
import com.desafios.accounts.repository.AccountRepository;
import com.desafios.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accRepository;

    @Override
    public AccountDTO getAccount(Long accountId) {
        Account acc = accRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account not found")
        );
        return null;
    }
}
