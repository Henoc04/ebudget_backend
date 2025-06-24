package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

   // @Query("SELECT a FROM Activity a WHERE a.budgetId = :budgetId")
    List<Activity> findByBudgetId(Long budgetId);
}
