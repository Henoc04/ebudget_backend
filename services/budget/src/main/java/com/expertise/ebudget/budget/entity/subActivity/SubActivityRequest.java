package com.expertise.ebudget.budget.entity.subActivity;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public record SubActivityRequest(
        Long id,
        String name,
        Integer quantity,
        Integer frequency,
        BigDecimal unitCost,
        Long activityId,
        Long nomenclatureId,
        Long financingId
) {
}
