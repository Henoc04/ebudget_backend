package com.expertise.ebudget.budget.entity.activity;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.subActivity.SubActivity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @OneToMany(mappedBy = "activity")
    private List<SubActivity> subActivities;

}
