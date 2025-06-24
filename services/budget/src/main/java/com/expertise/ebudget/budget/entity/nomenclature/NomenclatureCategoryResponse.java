package com.expertise.ebudget.budget.entity.nomenclature;

import jakarta.validation.constraints.NotBlank;

public record NomenclatureCategoryResponse(
        Long id,
        String name
) {
}
