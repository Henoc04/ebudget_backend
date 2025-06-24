package com.expertise.ebudget.budget.entity.financing;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record FinancingResponse(
        Long id,
        String name,
//        BigDecimal amount,
        String description
) {
}
