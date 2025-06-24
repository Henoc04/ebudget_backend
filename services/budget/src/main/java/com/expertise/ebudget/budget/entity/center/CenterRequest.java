package com.expertise.ebudget.budget.entity.center;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CenterRequest(
        Long id,
        @NotBlank(message = "The name of center is blank")
        String name,
        @NotBlank(message = "The location of center is blank")
        String location,
        @NotBlank(message = "The manager of center is not define")
        String manager,
        @NotNull(message = "The amount of center can not be null")
        @Positive(message = "The amount of center most be positive")
        BigDecimal amount,
        String iban
) {
}
