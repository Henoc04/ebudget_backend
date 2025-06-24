package com.expertise.ebudget.budget.entity.recipe;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.financing.Financing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RecipeResponse(
        Long id,
        String name,
        BigDecimal amount,
        RecipeStatus status,
        Long budgetFundingId
) {

}
