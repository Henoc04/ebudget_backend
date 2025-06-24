package com.expertise.ebudget.budget.repository;

import com.expertise.ebudget.budget.entity.financing.Financing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancingRepository extends JpaRepository<Financing, Long> {
}
