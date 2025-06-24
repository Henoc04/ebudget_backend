package com.expertise.ebudget.budget.entity.budget;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BudgetRequest(
        Long id,
        @Positive(message = "The year most be positive number")
        Integer year,
        String description,
        @Positive(message = "The center should not be null")
        Long centerId
) {
}
