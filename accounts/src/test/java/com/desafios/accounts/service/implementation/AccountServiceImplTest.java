package com.desafios.accounts.service.implementation;

import com.desafios.accounts.Utils;
import com.desafios.accounts.exception.types.AccountNotFoundException;
import com.desafios.accounts.model.Account;
import com.desafios.accounts.model.AccountDTO;
import com.desafios.accounts.repository.AccountRepository;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {

    @Mock
    AccountRepository accRepository;

    @InjectMocks
    AccountServiceImpl accService;

    @Test
    @SneakyThrows
    void getAccount_Success() {
        // given
        AccountDTO expectedAcc = Utils.readAcc("acc_test.json");
        Account acc = new Account()
                .setId(expectedAcc.id())
                .setUserId(expectedAcc.userId())
                .setBalance(expectedAcc.balance());

        given(accRepository.findById(expectedAcc.id())).willReturn(Optional.of(acc));

        // when
        AccountDTO actualAcc = accService.getAccount(expectedAcc.id());

        // then
        then(accRepository).should().findById(expectedAcc.id());
        assertThat(actualAcc).isNotNull();
        assertThat(actualAcc).isEqualTo(expectedAcc);
    }

    @Test
    @SneakyThrows
    void getAccount_Fails() {
        // given
        given(accRepository.findById(anyLong())).willReturn(Optional.empty());

        // when / then
        assertThatExceptionOfType(AccountNotFoundException.class).isThrownBy(
                () -> accService.getAccount(1L)
        );

        then(accRepository).should().findById(anyLong());
    }
}