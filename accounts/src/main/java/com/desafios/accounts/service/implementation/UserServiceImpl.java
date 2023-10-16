package com.desafios.accounts.service.implementation;

import com.desafios.accounts.exception.types.UserNotFoundException;
import com.desafios.accounts.feign.UserProxy;
import com.desafios.accounts.model.UserDTO;
import com.desafios.accounts.service.UserService;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserProxy userProxy;

    @Override
    public UserDTO getUser(Long userId) {
        UserDTO user;
        log.info("Searching user in external API: {}", userId);
        try {
            user = userProxy.getUserById(userId);
        } catch (FeignException e) {
            log.info("User not found: {}", e.getMessage());
            throw new UserNotFoundException("User " + userId + " not found");
        }

        return user;
    }

    @Override
    public Boolean userExists(Long userId) {
        UserDTO user = getUser(userId);
        return user != null;
    }
}
