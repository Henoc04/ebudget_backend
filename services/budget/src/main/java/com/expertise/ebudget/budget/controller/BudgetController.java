package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.budget.BudgetRequest;
import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.service.BudgetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/budgets")
@CrossOrigin(origins = "*")
public class BudgetController {

    private final BudgetService service;

    @PostMapping
    public ResponseEntity<Long> createBudget(@RequestBody @Valid BudgetRequest request){
        return ResponseEntity.ok(service.createBudget(request));
    }

    @GetMapping
    public ResponseEntity<List<BudgetResponse>> getAllBudgets(){
        return ResponseEntity.ok(service.getAllBudgets());
    }

    @GetMapping("/{budgetId}")
    public ResponseEntity<BudgetResponse> getBudgetById(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getBudgetById(budgetId));
    }

    @PutMapping
    public ResponseEntity<BudgetResponse> updateBudget(@RequestBody @Valid BudgetRequest request){
        return ResponseEntity.ok(service.updateBudget(request));
    }

    @DeleteMapping("/{budgetId}")
    public ResponseEntity<String> deleteBudgetById(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.deleteBudgetById(budgetId));
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<BudgetResponse>> getBudgetByCenterId(@PathVariable("centerId") Long centerId){
        return ResponseEntity.ok(service.getBudgetByCenterId(centerId));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<BudgetResponse>> getBudgetByYear(@PathVariable("year") Integer year){
        return ResponseEntity.ok(service.getBudgetByYear(year));
    }

    @GetMapping("/{budgetId}/activities")
    public ResponseEntity<List<ActivityResponse>> getActivitiesByBudget(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getActivitiesByBudget(budgetId));
    }


}
