package com.desafios.user.service.implementation;

import com.desafios.user.exception.types.UserNotFound;
import com.desafios.user.model.User;
import com.desafios.user.model.UserDTO;
import com.desafios.user.repository.UserRepository;
import com.desafios.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public UserDTO getUser(Long userId) {
        var user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFound("TODO: Create a proper exeception... User not found"));

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
