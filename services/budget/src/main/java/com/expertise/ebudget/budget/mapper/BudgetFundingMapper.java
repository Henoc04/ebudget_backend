package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingRequest;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingResponse;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class BudgetFundingMapper {


    private final ActivityMapper activityMapper;

    public BudgetFunding toBudgetFunding(@Valid BudgetFundingRequest request, Budget budget, Financing financing) {
        return BudgetFunding.builder()
                .amount(request.amount())
                .financing(financing)
                .budget(budget)
                .build();
    }

    public BudgetFundingResponse fromBudgetFunding(BudgetFunding budgetFunding) {
        return new BudgetFundingResponse(
                budgetFunding.getId(),
                budgetFunding.getAmount(),
                new BudgetResponse(
                        budgetFunding.getBudget().getId(),
                        budgetFunding.getBudget().getYear(),
                        budgetFunding.getBudget().getDescription(),
                        budgetFunding.getBudget().getCenterId(),
                        budgetFunding.getBudget().getActivities().stream()
                                .map(activityMapper::fromActivity)
                                .toList()
                ),
                new FinancingResponse(
                        budgetFunding.getFinancing().getId(),
                        budgetFunding.getFinancing().getName(),
//                        budgetFunding.getFinancing().getAmount(),
                        budgetFunding.getFinancing().getDescription()
                )
        );
    }
}
