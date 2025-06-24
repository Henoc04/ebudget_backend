package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.financing.FinancingRequest;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import com.expertise.ebudget.budget.entity.subActivity.SubActivityRequest;
import com.expertise.ebudget.budget.service.FinancingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/financing")
@CrossOrigin(origins = "*")
public class FinancingController {

    private final FinancingService service;

    @PostMapping
    public ResponseEntity<Long> createFinancing(@RequestBody @Valid FinancingRequest request){
        return ResponseEntity.ok(service.createFinancing(request));
    }

    @GetMapping
    public ResponseEntity<List<FinancingResponse>> getAllFinancing(){
        return ResponseEntity.ok(service.getAllFinancing());
    }

    @GetMapping("/{financingId}")
    public ResponseEntity<FinancingResponse> getFinancingById(@PathVariable("financingId") Long financingId){
        return ResponseEntity.ok(service.getFinancingById(financingId));
    }

    @PutMapping
    public ResponseEntity<FinancingResponse> updateFinancing(@RequestBody @Valid FinancingRequest request){
        return ResponseEntity.ok(service.updateFinancing(request));
    }

    @DeleteMapping("/{financingId}")
    public ResponseEntity<String> deleteFinancingById(@PathVariable("financingId") Long financingId){
        return ResponseEntity.ok(service.deleteFinancingById(financingId));
    }
}
