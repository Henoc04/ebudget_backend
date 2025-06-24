package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budget.BudgetRequest;
import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BudgetMapper {

    private final ActivityMapper activityMapper;

    public Budget toBudget(@Valid BudgetRequest request) {
        return Budget.builder()
                .year(request.year())
                .description(request.description())
                .centerId(request.centerId())
                .build();
    }

    public BudgetResponse fromBudget(Budget budget) {
        return new BudgetResponse(
                budget.getId(),
                budget.getYear(),
                budget.getDescription(),
                budget.getCenterId(),
                budget.getActivities().stream()
                        .map(activityMapper::fromActivity)
                        .toList()
        );
    }
}
