package com.expertise.ebudget.budget.entity.budgetFunding;

import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record BudgetFundingResponse(
        Long id,
        BigDecimal amount,
        BudgetResponse budget,
        FinancingResponse financing
) {
}
