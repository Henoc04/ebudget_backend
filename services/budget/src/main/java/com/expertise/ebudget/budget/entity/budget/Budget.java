package com.expertise.ebudget.budget.entity.budget;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private String description;
    private Long centerId;

    @OneToMany(mappedBy = "budget")
    private List<Activity> activities;

    @OneToMany(mappedBy = "budget")
    private List<BudgetFunding> financingOfBudgets;

}
