package com.expertise.ebudget.budget.entity.nomenclature;

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
public class Nomenclature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @OneToMany(mappedBy = "nomenclature")
    private List<SubActivity> subActivities;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
