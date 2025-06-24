package com.expertise.ebudget.budget.entity.financing;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record FinancingRequest(
        Long id,
        @NotBlank(message = "The name should not be empty")
        String name,
//        @Positive(message = "The amount should be positive number")
//        BigDecimal amount,
        String description
) {
}
