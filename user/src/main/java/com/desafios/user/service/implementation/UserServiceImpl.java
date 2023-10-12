package com.desafios.user.service.implementation;

import com.desafios.user.exception.types.UserNotFoundException;
import com.desafios.user.model.User;
import com.desafios.user.model.UserDTO;
import com.desafios.user.repository.UserRepository;
import com.desafios.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public UserDTO getUser(Long userId) {
        log.info("getting user {}", userId);
        var user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User " + userId + " not found"));

        log.info("user {} found", userId);
        return mapToDTO(user);
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFullName(),
                user.getCpf(),
                user.getEmail(),
                user.getRole().name()
        );
    }

}
