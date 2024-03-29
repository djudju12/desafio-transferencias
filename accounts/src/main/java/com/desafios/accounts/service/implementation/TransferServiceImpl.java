package com.desafios.accounts.service.implementation;

import com.desafios.accounts.exception.types.InsufficientFundException;
import com.desafios.accounts.exception.types.UserNotFoundException;
import com.desafios.accounts.model.AccountDTO;
import com.desafios.accounts.model.Transfer;
import com.desafios.accounts.model.TransferDTO;
import com.desafios.accounts.repository.TransferRepository;
import com.desafios.accounts.service.AccountService;
import com.desafios.accounts.service.TransferService;
import com.desafios.accounts.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {

    private UserService userService;
    private AccountService accService;
    private TransferRepository transferRepository;

    @Override
    @Transactional
    public TransferDTO createTransfer(TransferDTO transferDTO) {
        log.info("Creating transfer: {}", transferDTO);

        var fromAcc = accService.getAccount(transferDTO.fromAccountId());
        if (!userService.userExists(fromAcc.userId())) {
            throw new UserNotFoundException("User " + fromAcc.userId() + " not found");
        }

        if (fromAcc.balance() < transferDTO.amount()) {
            throw new InsufficientFundException("Current balance is less than the amount to be transferred");
        }

        AccountDTO newFrom = new AccountDTO(
                fromAcc.id(),
                fromAcc.userId(),
                fromAcc.balance() - transferDTO.amount());

        var toAcc = accService.getAccount(transferDTO.toAccountId());
        if (!userService.userExists(toAcc.userId())) {
            throw new UserNotFoundException("User " + toAcc.userId() + " not found");
        }

        AccountDTO newTo = new AccountDTO(
                toAcc.id(),
                toAcc.userId(),
                toAcc.balance() + transferDTO.amount());

        Transfer transfer = new Transfer()
                .setFromAccId(transferDTO.fromAccountId())
                .setToAccId(transferDTO.toAccountId())
                .setAmount(transferDTO.amount());

        accService.saveAccounts(newFrom, newTo);
        transferRepository.save(transfer);
        log.info("transfer created: {}", transferDTO);

        return mapToDTO(transfer);
    }

    private TransferDTO mapToDTO(Transfer transfer) {
        return new TransferDTO(
                transfer.getId(),
                transfer.getFromAccId(),
                transfer.getToAccId(),
                transfer.getAmount()
        );
    }
}
