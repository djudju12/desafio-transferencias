package com.desafios.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record AccountDTO(
        @JsonProperty("acc_id")
        Long id,

        @JsonProperty("user_id")
        @NotBlank(message = "necessario informar o id do usuario")
        Long userId,

        @JsonProperty("balance")
        Double balance
) { }
