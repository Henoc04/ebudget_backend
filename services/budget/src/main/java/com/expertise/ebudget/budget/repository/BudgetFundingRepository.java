package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetFundingRepository extends JpaRepository<BudgetFunding, Long> {

    List<BudgetFunding> findBudgetFundingsByBudgetId(Long budgetId);

    @Query(value = "select * from budget_funding bf where bf.budget_id = :budgetId and bf.financing_id = :financingId",  nativeQuery = true)
    BudgetFunding findBudgetFundingByBudgetIdAndFinancingId(Long budgetId, Long financingId);
}
