package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.nomenclature.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NomenclatureCategoryRepository extends JpaRepository<Category, Long> {
}
