package com.desafios.accounts.service;

import com.desafios.accounts.model.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO getAccount(Long accountId);
    List<AccountDTO> saveAccounts(AccountDTO... accountDTO);
}
