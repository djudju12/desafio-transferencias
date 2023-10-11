package com.desafios.user.controller;

import com.desafios.user.Utils;
import com.desafios.user.model.UserDTO;
import com.desafios.user.service.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    final private String userResource = "user_test.json";

    @Test
    @SneakyThrows
    void getUser_Success() {
        // given
        UserDTO expectedUser = Utils.readUser(userResource);
        given(userService.getUser(expectedUser.id())).willReturn(expectedUser);

        // when / then
        mockMvc.perform(get("/user/" + expectedUser.id()))
                .andExpect(status().isOk())
                .andExpect(content().json(Utils.readResource(userResource)));

        then(userService).should().getUser(expectedUser.id());
    }

}