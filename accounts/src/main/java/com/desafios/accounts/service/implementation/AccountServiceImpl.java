package com.desafios.accounts.service.implementation;

import com.desafios.accounts.exception.types.AccountNotFoundException;
import com.desafios.accounts.model.Account;
import com.desafios.accounts.model.AccountDTO;
import com.desafios.accounts.repository.AccountRepository;
import com.desafios.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountRepository accRepository;

    @Override
    public AccountDTO getAccount(Long accountId) {
        Account acc = accRepository.findById(accountId).orElseThrow(
                () -> new AccountNotFoundException("Account " + accountId + " not found")
        );

        log.info("Account found: {}", acc);
        return mapToDTO(acc);
    }

    @Override
    public List<AccountDTO> saveAccounts(AccountDTO... dtoList) {
        List<Account> accs = new ArrayList<>();
        log.info("Saving accounts. Total accounts: {}", dtoList.length);

        for (AccountDTO dto : dtoList) {
            if (!accRepository.existsById(dto.userId())) {
                throw new AccountNotFoundException("Account " + dto.userId() + " not foud");
            }

            accs.add(mapToEntity(dto));
        }

        return accRepository
                .saveAll(accs)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private AccountDTO mapToDTO(Account acc) {
        return new AccountDTO(
                acc.getId(),
                acc.getUserId(),
                acc.getBalance()
        );
    }

    private Account mapToEntity(AccountDTO accountDTO) {
        return new Account()
                .setId(accountDTO.id())
                .setUserId(accountDTO.userId())
                .setBalance(accountDTO.balance());
    }
}
