package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.activity.ActivityRequest;
import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import com.expertise.ebudget.budget.mapper.ActivityMapper;
import com.expertise.ebudget.budget.mapper.SubActivityMapper;
import com.expertise.ebudget.budget.repository.ActivityRepository;
import com.expertise.ebudget.budget.repository.BudgetRepository;
import com.expertise.ebudget.budget.repository.SubActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository repository;
    private final SubActivityRepository subActivityRepository;
    private final BudgetRepository budgetRepository;
    private final ActivityMapper mapper;
    private final SubActivityMapper subActivityMapper;

    public Long createActivity(@Valid ActivityRequest request) {
        var budget = budgetRepository.findById(request.budgetId())
                .orElseThrow(()-> new EntityNotFoundException("This budget don't exist"));
        return repository.save(mapper.toActivity(budget, request)).getId();
    }

    public List<ActivityResponse> getAllActivities() {
        return repository.findAll().stream()
                .map(mapper::fromActivity)
                .toList();
    }

    public String deleteActivity(Long activityId) {
        var activity = repository.findById(activityId)
                .orElseThrow(()-> new EntityNotFoundException("This activity don't exist"));
        repository.delete(activity);
        return "This activity is deleted successfully";
    }

    public List<SubActivityResponse> getSubActivitiesByActivitiesId(Long activityId) {

        return subActivityRepository.findByActivityId(activityId).stream()
                .map(subActivityMapper::fromSubActivity)
                .toList();
    }

    public ActivityResponse updateActivity(@Valid ActivityRequest request) {
        var activity = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("Any activity don't exist with this ID"));
        activity.setName(request.name());
        repository.save(activity);
        return mapper.fromActivity(activity);
    }
}
