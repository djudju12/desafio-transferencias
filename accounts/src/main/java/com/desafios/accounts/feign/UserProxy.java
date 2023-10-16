package com.desafios.accounts.feign;

import com.desafios.accounts.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8081/users/")
public interface UserProxy {
    @GetMapping(value = "/{userId}", produces = "application/json")
    UserDTO getUserById(@PathVariable Long userId);
}
