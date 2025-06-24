package com.expertise.ebudget.budget.entity.recipe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RecipeRequest(
        Long id,
        @NotBlank(message = "The name of recipe should not be empty")
        String name,
        @Positive(message = "The amount should be a positive number")
        BigDecimal amount,
        RecipeStatus status,
        @NotNull(message = "The financing should not be null")
        Long budgetFundingId
) {

}
