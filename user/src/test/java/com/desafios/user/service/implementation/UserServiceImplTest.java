package com.desafios.user.service.implementation;

import com.desafios.user.Utils;
import com.desafios.user.exception.types.UserNotFoundException;
import com.desafios.user.model.User;
import com.desafios.user.model.UserDTO;
import com.desafios.user.model.UserRole;
import com.desafios.user.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(SpringExtension.class)
@Slf4j
class UserServiceImplTest {

    @Mock
    UserRepository userRepositorys;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @SneakyThrows
    void getUser_Success() {
        // given
        UserDTO expectedUser = Utils.readUser("user_test.json");
        User user = new User()
                .setId(expectedUser.id())
                .setFullName(expectedUser.fullName())
                .setCpf(expectedUser.cpf())
                .setEmail(expectedUser.email())
                .setRole(UserRole.valueOf(expectedUser.role()));

        given(userRepositorys.findById(user.getId())).willReturn(Optional.of(user));

        // when
        UserDTO userDTO = userService.getUser(user.getId());

        // then
        then(userRepositorys).should().findById(user.getId());
        assertThat(userDTO).isNotNull();
        assertThat(userDTO).isEqualTo(expectedUser);
    }

    @Test
    void getUser_Fail() {
        // given
        given(userRepositorys.findById(any(Long.class))).willReturn(Optional.empty());

        // when / then
        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(
                () -> userService.getUser(0L));

        then(userRepositorys).should().findById(any(Long.class));
    }
}