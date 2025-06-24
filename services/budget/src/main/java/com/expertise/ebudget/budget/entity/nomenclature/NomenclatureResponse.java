package com.expertise.ebudget.budget.entity.nomenclature;

public record NomenclatureResponse(
        Long id,
        Integer code,
        String name,
        String description,
        CategoryResponse category
) {
}
