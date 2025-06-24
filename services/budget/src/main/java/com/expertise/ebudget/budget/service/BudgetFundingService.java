package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingRequest;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingResponse;
import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.mapper.BudgetFundingMapper;
import com.expertise.ebudget.budget.repository.BudgetFundingRepository;
import com.expertise.ebudget.budget.repository.BudgetRepository;
import com.expertise.ebudget.budget.repository.FinancingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BudgetFundingService {

    private final BudgetFundingRepository repository;
    private final BudgetRepository budgetRepository;
    private final FinancingRepository financingRepository;
    private final BudgetFundingMapper mapper;

    public Long createBudgetFunding(@Valid BudgetFundingRequest request) {
        var budget = budgetRepository.findById(request.budgetId())
                .orElseThrow(()-> new EntityNotFoundException("This budget don't exist"));
        var financing = financingRepository.findById(request.financingId())
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));

        return repository.save(mapper.toBudgetFunding(request, budget, financing)).getId();
    }

    public List<BudgetFundingResponse> getAllBudgetFundings() {
        return repository.findAll().stream()
                .map(mapper::fromBudgetFunding)
                .toList();
    }

    public List<BudgetFundingResponse> getBudgetFundingsByBudgetId(Long budgetId) {
        var budget = budgetRepository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget don't exist"));

        return repository.findBudgetFundingsByBudgetId(budgetId).stream()
                .map(mapper::fromBudgetFunding)
                .toList();
    }

    public BudgetFundingResponse getBudgetFundingsByBudgetIdAndFinancingId(Long budgetId, Long financingId) {
        var budget = budgetRepository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget don't exist"));
        var financing = financingRepository.findById(financingId)
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));

        return mapper.fromBudgetFunding(repository.findBudgetFundingByBudgetIdAndFinancingId(budgetId, financingId));
    }
}
