package com.expertise.ebudget.budget.entity.budget;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record BudgetResponse(
        Long id,
        Integer year,
        String description,
        Long centerId,
        List<ActivityResponse> activities
) {
}
