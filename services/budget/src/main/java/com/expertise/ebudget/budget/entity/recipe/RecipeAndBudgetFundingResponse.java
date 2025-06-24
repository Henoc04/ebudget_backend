package com.expertise.ebudget.budget.entity.recipe;

import java.math.BigDecimal;

public record RecipeAndBudgetFundingResponse(
        Long recipeId,
        String financing,
        String recipe_name,
        BigDecimal recipe_amount,
        String recipe_status,
        BigDecimal bank_account
) {
}
