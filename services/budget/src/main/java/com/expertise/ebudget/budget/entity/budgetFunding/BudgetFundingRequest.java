package com.expertise.ebudget.budget.entity.budgetFunding;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.financing.Financing;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record BudgetFundingRequest(
        Long id,
        @Positive(message = "The amount should not be negative")
        BigDecimal amount,
        @NotNull(message = "The budget is consolatory")
        Long budgetId,
        @NotNull(message = "The financing is consolatory")
        Long financingId
) {
}
