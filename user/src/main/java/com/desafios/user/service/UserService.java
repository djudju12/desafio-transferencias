package com.desafios.user.service;

import com.desafios.user.model.UserDTO;

public interface UserService {
    UserDTO getUser(Long userId);
}
