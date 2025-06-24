package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import com.expertise.ebudget.budget.entity.nomenclature.CategoryResponse;
import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityRequest;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubActivityMapper {

    public SubActivity toSubActivity(@Valid Activity activity, Financing financing, Nomenclature nomenclature, SubActivityRequest request) {
        return SubActivity.builder()
                .name(request.name())
                .quantity(request.quantity())
                .frequency(request.frequency())
                .unitCost(request.unitCost())
                .activity(activity)
                .nomenclature(nomenclature)
                .financing(financing)
                .build();
    }

    public SubActivityResponse fromSubActivity(SubActivity subActivity) {
        return new SubActivityResponse(
                subActivity.getId(),
                subActivity.getName(),
                subActivity.getQuantity(),
                subActivity.getFrequency(),
                subActivity.getUnitCost(),
                subActivity.getActivity().getId(),
                new NomenclatureResponse(
                        subActivity.getNomenclature().getId(),
                        subActivity.getNomenclature().getCode(),
                        subActivity.getNomenclature().getName(),
                        subActivity.getNomenclature().getDescription(),
                        new CategoryResponse(
                                subActivity.getNomenclature().getCategory().getId(),
                                subActivity.getNomenclature().getCategory().getName()
                        )
                ),
                new FinancingResponse(
                        subActivity.getFinancing().getId(),
                        subActivity.getFinancing().getName(),
//                        subActivity.getFinancing().getAmount(),
                        subActivity.getFinancing().getDescription()
                )
        );
    }

}