package com.expertise.ebudget.budget.controller;


import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingRequest;
import com.expertise.ebudget.budget.entity.budgetFunding.BudgetFundingResponse;
import com.expertise.ebudget.budget.service.BudgetFundingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/budgetfundings")
@CrossOrigin(origins = "*")
public class BudgetFundingController {

    private final BudgetFundingService service;

    @PostMapping
    public ResponseEntity<Long> createBudgetFunding(@RequestBody @Valid BudgetFundingRequest request){
        return ResponseEntity.ok(service.createBudgetFunding(request));
    }

    @GetMapping
    public ResponseEntity<List<BudgetFundingResponse>> getAllBudgetFundings(){
        return ResponseEntity.ok(service.getAllBudgetFundings());
    }

    @GetMapping("/budget/{budgetId}")
    public ResponseEntity<List<BudgetFundingResponse>> getBudgetFundingsByBudgetId(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getBudgetFundingsByBudgetId(budgetId));
    }

    @GetMapping("/budgetfinancing/{budgetId}/{financingId}")
    public ResponseEntity<BudgetFundingResponse> getBudgetFundingsByBudgetIdAndFinancingId(@PathVariable("budgetId") Long budgetId, @PathVariable("financingId") Long financingId){
        return ResponseEntity.ok(service.getBudgetFundingsByBudgetIdAndFinancingId(budgetId, financingId));
    }
}
