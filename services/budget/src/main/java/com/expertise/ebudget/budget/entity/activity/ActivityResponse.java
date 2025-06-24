package com.expertise.ebudget.budget.entity.activity;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;

import java.util.List;

public record ActivityResponse(
        Long id,
        String name,
        Long budgetId,
        List<SubActivityResponse> subActivities
) {
}
