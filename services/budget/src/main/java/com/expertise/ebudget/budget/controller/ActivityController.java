package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.activity.ActivityRequest;
import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.budget.BudgetRequest;
import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import com.expertise.ebudget.budget.service.ActivityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService service;

    @PostMapping
    public ResponseEntity<Long> createActivity(@RequestBody @Valid ActivityRequest request){
        return ResponseEntity.ok(service.createActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllActivities(){
        return ResponseEntity.ok(service.getAllActivities());
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<String> deleteActivity(@PathVariable("activityId") Long activityId){
        return ResponseEntity.ok(service.deleteActivity(activityId));
    }

    @GetMapping("/{activityId}/subactivities")
    public ResponseEntity<List<SubActivityResponse>> getSubActivitiesByActivitiesId(@PathVariable("activityId") Long activityId){
        return ResponseEntity.ok(service.getSubActivitiesByActivitiesId(activityId));
    }

    @PutMapping
    public ResponseEntity<ActivityResponse> updateActivity(@RequestBody @Valid ActivityRequest request){
        return ResponseEntity.ok(service.updateActivity(request));
    }

}
