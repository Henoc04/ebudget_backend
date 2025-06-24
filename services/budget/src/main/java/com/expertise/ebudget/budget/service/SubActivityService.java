package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.financing.FinancingBalanceByBudget;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureBalanceByBudget;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityRequest;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import com.expertise.ebudget.budget.mapper.SubActivityMapper;
import com.expertise.ebudget.budget.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubActivityService {

    private final SubActivityRepository repository;
    private final ActivityRepository activityRepository;
    private final FinancingRepository financingRepository;
    private final NomenclatureRepository nomenclatureRepository;
    private final BudgetRepository budgetRepository;
    private final SubActivityMapper mapper;

    public Long createSubActivity(@Valid SubActivityRequest request) {
        var activity = activityRepository.findById(request.activityId())
                .orElseThrow(()-> new EntityNotFoundException("This activity don't exist"));
        var financing = financingRepository.findById(request.financingId())
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));
        var nomenclature = nomenclatureRepository.findById(request.nomenclatureId())
                .orElseThrow(()-> new EntityNotFoundException("This nomenclature don't exist"));

        return repository.save(mapper.toSubActivity(activity, financing, nomenclature, request)).getId();
    }

    public List<SubActivityResponse> getAllSubActivities() {
        return  repository.findAll().stream()
                .map(mapper::fromSubActivity)
                .toList();
    }

    public SubActivityResponse updateSubActivity(@Valid SubActivityRequest request) {
        var subActivity = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("No sub_activity found with this ID"));
        var financing = financingRepository.findById(request.financingId())
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));
        var nomenclature = nomenclatureRepository.findById(request.nomenclatureId())
                .orElseThrow(()-> new EntityNotFoundException("This nomenclature don't exist"));

        subActivity.setName(request.name());
        subActivity.setQuantity(request.quantity());
        subActivity.setFrequency(request.frequency());
        subActivity.setUnitCost(request.unitCost());
        subActivity.setNomenclature(nomenclature);
        subActivity.setFinancing(financing);

        repository.save(subActivity);

        return mapper.fromSubActivity(subActivity);

    }

    public String deleteSubActivity(Long subActivityId) {
        var subActivity = repository.findById(subActivityId)
                .orElseThrow(()-> new EntityNotFoundException("No sub_activity found with this ID"));
        repository.deleteById(subActivityId);
        return "This sub_activity is deleted successfully";
    }

    public List<FinancingBalanceByBudget> getBalanceByFinancing(Long budgetId) {
        var budget = budgetRepository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget not exist"));
        return repository.getBalanceByBudget(budgetId);
    }

    public List<NomenclatureBalanceByBudget> getNomenclatureBalanceByBudget(Long budgetId) {
        var budget = budgetRepository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget not exist"));
       return repository.getNomenclatureBalanceByBudget(budgetId);
    }
}
