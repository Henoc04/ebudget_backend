package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.recipe.Recipe;
import com.expertise.ebudget.budget.entity.recipe.RecipeAndBudgetFundingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT r.id AS recipeId, f.name AS financing, r.name AS recipe_name, r.amount AS recipe_amount, r.status AS recipe_status, bf.amount AS bank_account\n" +
            "FROM  budget_funding bf\n" +
            "JOIN recipe r ON r.budget_funding_id = bf.id\n" +
            "JOIN financing f ON bf.financing_id = f.id\n" +
            "JOIN budget b ON bf.budget_id = b.id\n" +
            "WHERE b.id = :budgetId",  nativeQuery = true)
    List<RecipeAndBudgetFundingResponse> findRecipesAndBudgetFundingByBudget(Long budgetId);
}
