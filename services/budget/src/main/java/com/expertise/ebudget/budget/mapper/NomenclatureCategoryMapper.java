package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.nomenclature.Category;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureCategoryMapper {
    public Category toNomenclatureCategory(@Valid NomenclatureCategoryRequest request) {
        return Category.builder()
                .name(request.name())
                .build();
    }

    public NomenclatureCategoryResponse fromNomenclatureCategory(Category category) {
        return new NomenclatureCategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
