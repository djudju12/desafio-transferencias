package com.desafios.accounts.service;

import com.desafios.accounts.model.AccountDTO;

public interface AccountService {
    AccountDTO getAccount(Long accountId);
}
