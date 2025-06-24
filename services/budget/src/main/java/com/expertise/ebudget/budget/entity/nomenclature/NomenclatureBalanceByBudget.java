package com.expertise.ebudget.budget.entity.nomenclature;

import java.math.BigDecimal;

public record NomenclatureBalanceByBudget(
        Integer code,
        String libele,
        String financing,
        BigDecimal total
) {
}
