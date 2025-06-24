package com.expertise.ebudget.budget.entity.activity;

import com.expertise.ebudget.budget.entity.budget.Budget;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record ActivityRequest(
        Long id,
        String name,
        Long budgetId
) {
}
