package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query("SELECT b FROM Budget b WHERE b.centerId = :budgetId")
    List<Budget> findBudgetsByCenterId(Long budgetId);

    @Query("SELECT b FROM Budget b WHERE b.year = :year")
    List<Budget> findBudgetsByYear(Integer year);
}
