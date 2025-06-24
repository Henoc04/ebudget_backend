package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.nomenclature.Nomenclature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NomenclatureRepository extends JpaRepository<Nomenclature, Long> {

    List<Nomenclature> findByCategoryId(Long categoryId);
}
