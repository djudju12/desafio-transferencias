package com.desafios.accounts.service;

import com.desafios.accounts.model.UserDTO;

public interface UserService {
    UserDTO getUser(Long userId);
}
