package com.expertise.ebudget.budget.entity.recipe;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.financing.Financing;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RecipeStatus status;

    @ManyToOne
    @JoinColumn(name = "budgetFunding_id")
    private BudgetFunding budgetFunding;
}
