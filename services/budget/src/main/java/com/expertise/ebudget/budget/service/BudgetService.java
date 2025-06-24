package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.budget.BudgetRequest;
import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.entity.center.CenterClient;
import com.expertise.ebudget.budget.mapper.ActivityMapper;
import com.expertise.ebudget.budget.mapper.BudgetMapper;
import com.expertise.ebudget.budget.repository.ActivityRepository;
import com.expertise.ebudget.budget.repository.BudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class BudgetService {

    private final BudgetRepository repository;
    private final ActivityRepository activityRepository;
    private CenterClient centerClient;
    private final BudgetMapper mapper;
    private final ActivityMapper activityMapper;

    public Long createBudget(@Valid BudgetRequest request) {
        var center = centerClient.findById(request.centerId())
                .orElseThrow(()-> new EntityNotFoundException("Any center don't exist with this ID"));
        return repository.save(mapper.toBudget(request)).getId();
    }

    public List<BudgetResponse> getAllBudgets() {
        return repository.findAll().stream()
                .map(mapper::fromBudget)
                .toList();
    }

    public BudgetResponse getBudgetById(Long budgetId) {
        Budget budget = repository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("Not any budget is find with this ID"));
        return mapper.fromBudget(budget);
    }

    public BudgetResponse updateBudget(@Valid BudgetRequest request) {
        var budget = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("This budget not exist"));
        budget.setYear(request.year());
        budget.setCenterId(request.centerId());
        budget.setDescription(request.description());

        repository.save(budget);
        return mapper.fromBudget(budget);
    }

    public String deleteBudgetById(Long budgetId) {
        var budget = repository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget not exist"));
        repository.deleteById(budget.getId());
        return "This budget is delete successfully";
    }

    public List<BudgetResponse> getBudgetByCenterId(Long centerId) {
        return repository.findBudgetsByCenterId(centerId).stream()
                .map(mapper::fromBudget)
                .toList();
    }

    public List<BudgetResponse> getBudgetByYear(Integer year) {
        return repository.findBudgetsByYear(year).stream()
                .map(mapper::fromBudget)
                .toList();
    }

    public List<ActivityResponse> getActivitiesByBudget(Long budgetId) {
        var budget = repository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget not exist"));
        return activityRepository.findByBudgetId(budgetId).stream()
                .map(activityMapper::fromActivity)
                .toList();
    }

}
