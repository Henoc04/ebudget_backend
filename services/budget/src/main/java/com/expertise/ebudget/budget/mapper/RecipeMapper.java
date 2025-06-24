package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.recipe.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RecipeMapper {
    public Recipe toRecipe(BudgetFunding budgetFunding, @Valid RecipeRequest request) {
        return Recipe.builder()
                .name(request.name())
                .amount(request.amount())
                .status(RecipeStatus.PENDING)
                .budgetFunding(budgetFunding)
                .build();
    }

    public RecipeResponse fromRecipe(Recipe recipe) {
        return new RecipeResponse(
                recipe.getId(),
                recipe.getName(),
                recipe.getAmount(),
                recipe.getStatus(),
                recipe.getBudgetFunding().getId()
        );
    }
}
