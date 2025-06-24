package com.expertise.ebudget.budget.entity.center;

import java.math.BigDecimal;

public record CenterResponse(
        Long id,
        String name,
        String location,
        String manager,
        BigDecimal amount,
        String iban
) {
}
