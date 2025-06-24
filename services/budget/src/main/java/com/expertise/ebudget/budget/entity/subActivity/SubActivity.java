package com.expertise.ebudget.budget.entity.subActivity;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class SubActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Integer frequency;
    private BigDecimal unitCost;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    @ManyToOne
    @JoinColumn(name = "financing_id")
    private Financing financing;

}
