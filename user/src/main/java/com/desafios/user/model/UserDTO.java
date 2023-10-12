package com.desafios.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(

        @JsonProperty("user_id")
        Long id,

        @NotBlank(message = "Nome não pode ser vazio")
        @JsonProperty("full_name")
        String fullName,

        @NotBlank(message = "CPF não pode ser vazio")
        @Min(value = 11, message = "CPF deve ter 11 dígitos")
        @JsonProperty("cpf")
        String cpf,

        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "Email inválido")
        @JsonProperty("email")
        String email,

        @NotBlank(message = "necessario informar a funcao do usuario")
        @Pattern(regexp = "^(LOJISTA|USUARIO)$", message = "funcao deve ser LOJISTA ou USUARIO")
        @JsonProperty("role")
        String role
)
{ }
