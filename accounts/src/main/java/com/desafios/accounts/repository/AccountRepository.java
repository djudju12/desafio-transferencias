package com.desafios.accounts.repository;

import com.desafios.accounts.model.Account;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;

@Observed
public interface AccountRepository extends JpaRepository<Account, Long> {
}
