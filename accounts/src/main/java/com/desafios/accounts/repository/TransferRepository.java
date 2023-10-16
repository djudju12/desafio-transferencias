package com.desafios.accounts.repository;

import com.desafios.accounts.model.Transfer;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;

@Observed
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
