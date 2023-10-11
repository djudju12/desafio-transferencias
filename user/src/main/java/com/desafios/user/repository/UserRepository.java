package com.desafios.user.repository;

import com.desafios.user.model.User;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;

@Observed
public interface UserRepository extends JpaRepository<User, Long> { }
