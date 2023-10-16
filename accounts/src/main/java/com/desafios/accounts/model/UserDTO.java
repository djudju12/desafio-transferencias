package com.desafios.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(

    @JsonProperty("user_id")
    Long id,

    @JsonProperty("full_name")
    String FullName,

    @JsonProperty("cpf")
    String cpf,

    @JsonProperty("email")
    String email,

    @JsonProperty("role")
    String role

) { }
