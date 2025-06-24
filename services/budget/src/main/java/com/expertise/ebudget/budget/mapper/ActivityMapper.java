package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.activity.Activity;
import com.expertise.ebudget.budget.entity.activity.ActivityRequest;
import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.budget.Budget;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import com.expertise.ebudget.budget.entity.nomenclature.CategoryResponse;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActivityMapper {

    private final SubActivityMapper subActivityMapper;

    public Activity toActivity(@Valid Budget budget, ActivityRequest request) {
        return Activity.builder()
                .name(request.name())
                .budget(budget)
                .build();
    }

    public ActivityResponse fromActivity(Activity activity) {
        return new ActivityResponse(
                activity.getId(),
                activity.getName(),
                activity.getBudget().getId(),
                activity.getSubActivities().stream()
                        .map(subActivityMapper::fromSubActivity)
                        .toList()
        );
    }
}
