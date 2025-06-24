package com.expertise.ebudget.budget.entity.budgetFunding;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class BudgetFunding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private Financing financing;

    @OneToMany(mappedBy = "budgetFunding")
    private List<Recipe> recipes;
}
