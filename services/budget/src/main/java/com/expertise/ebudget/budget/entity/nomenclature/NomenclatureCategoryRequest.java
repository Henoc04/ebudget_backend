package com.expertise.ebudget.budget.entity.nomenclature;

import jakarta.validation.constraints.NotBlank;

public record NomenclatureCategoryRequest(
        Long id,
        @NotBlank(message = "The category name must not be null or empty")
        String name
) {
}
