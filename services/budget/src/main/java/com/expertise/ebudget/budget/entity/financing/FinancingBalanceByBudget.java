package com.expertise.ebudget.budget.entity.financing;

import java.math.BigDecimal;

public record FinancingBalanceByBudget(
        String financing,
        BigDecimal total
) {
}
