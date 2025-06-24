package com.expertise.ebudget.budget.entity.nomenclature;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record NomenclatureRequest(
        Long id,
        @Positive(message = "The code of nomenclature should be positive")
        Integer code,
        @NotBlank(message = "The name of nomenclature should not be empty")
        String name,
        String description,
        @Positive(message = "The category ID most be positive")
        Long categoryId
) {
}
