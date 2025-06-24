package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.financing.FinancingBalanceByBudget;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureBalanceByBudget;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityRequest;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityResponse;
import com.expertise.ebudget.budget.service.SubActivityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/subactivities")
@CrossOrigin(origins = "*")
public class SubActivityController {


    private final SubActivityService service;

    @PostMapping
    public ResponseEntity<Long> createSubActivity(@RequestBody @Valid SubActivityRequest request){
        return ResponseEntity.ok(service.createSubActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<SubActivityResponse>> getAllSubActivities(){
        return ResponseEntity.ok(service.getAllSubActivities());
    }

    @PutMapping
    public ResponseEntity<SubActivityResponse> updateSubActivity(@RequestBody @Valid SubActivityRequest request){
        return ResponseEntity.ok(service.updateSubActivity(request));
    }


    @DeleteMapping("/{subActivityId}")
    public ResponseEntity<String> deleteSubActivity(@PathVariable("subActivityId") Long subActivityId){
        return ResponseEntity.ok(service.deleteSubActivity(subActivityId));
    }

    @GetMapping("/{budgetId}/balance")
    public ResponseEntity<List<FinancingBalanceByBudget>> getBalanceByFinancing(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getBalanceByFinancing(budgetId));
    }

    @GetMapping("/{budgetId}/nomenclature/balance")
    public ResponseEntity<List<NomenclatureBalanceByBudget>> getNomenclatureBalanceByBudget(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getNomenclatureBalanceByBudget(budgetId));
    }

}
