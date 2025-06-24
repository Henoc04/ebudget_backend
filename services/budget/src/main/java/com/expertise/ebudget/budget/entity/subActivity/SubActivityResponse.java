package com.expertise.ebudget.budget.entity.subActivity;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;

import java.math.BigDecimal;

public record SubActivityResponse(
        Long id,
        String name,
        Integer quantity,
        Integer frequency,
        BigDecimal unitCost,
        Long activityId,
        NomenclatureResponse nomenclature,
        FinancingResponse financing
) {
}
