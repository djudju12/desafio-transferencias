package com.desafios.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransferDTO(
        @JsonProperty("id")
        Long id,

        @JsonProperty("from_acc_id")
        @NotNull(message = "from_acc_id is mandatory")
        @Min(value = 1, message = "from_acc_id must be greater than 0")
        Long fromAccountId,

        @JsonProperty("to_acc_id")
        @NotNull(message = "to_acc_id is mandatory")
        @Min(value = 1, message = "to_acc_id must be greater than 0")
        Long toAccountId,

        @JsonProperty("amount")
        @NotNull(message = "amount is mandatory")
        @Min(value = 0, message = "amount must be greater than or equal to 0")
        Double amount
) {
}
