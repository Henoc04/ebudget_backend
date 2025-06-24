package com.expertise.ebudget.budget.entity.financing;

import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFunding;
import com.expertise.ebudget.budget.entity.recipe.Recipe;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
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
public class Financing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private BigDecimal amount;
    private String description;

    @OneToMany(mappedBy = "financing")
    private List<SubActivity> subActivities;

    @OneToMany(mappedBy = "financing")
    private List<BudgetFunding> budgetFundings;
}
