package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.nomenclature.CategoryResponse;
import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class NomenclatureMapper {
    public Nomenclature toNomenclature(@Valid NomenclatureRequest request) {
        return Nomenclature.builder()
                .code(request.code())
                .name(request.name())
                .description(request.description())
                .build();
    }

    public NomenclatureResponse fromNomenclature(Nomenclature nomenclature) {
        return new NomenclatureResponse(
                nomenclature.getId(),
                nomenclature.getCode(),
                nomenclature.getName(),
                nomenclature.getDescription(),
                new CategoryResponse(
                        nomenclature.getCategory().getId(),
                        nomenclature.getCategory().getName()
                )
        );
    }
}
