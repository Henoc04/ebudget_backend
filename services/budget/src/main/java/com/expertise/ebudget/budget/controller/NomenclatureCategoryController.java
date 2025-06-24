package com.expertise.ebudget.budget.controller;


import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryResponse;
import com.expertise.ebudget.budget.service.NomenclatureCategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/nomenclatures/categories")
@CrossOrigin(origins = "*")
public class NomenclatureCategoryController {

    private final NomenclatureCategoryService service;

    @PostMapping
    public ResponseEntity<Long> createNomenclatureCategory(@RequestBody @Valid NomenclatureCategoryRequest request){
        return ResponseEntity.ok(service.createNomenclatureCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<NomenclatureCategoryResponse>> getAllNomenclatureCategories(){
        return ResponseEntity.ok(service.getAllNomenclatureCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<NomenclatureCategoryResponse> getNomenclatureCategoryById(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(service.getNomenclatureCategoryById(categoryId));
    }

    @PutMapping
    public ResponseEntity<NomenclatureCategoryResponse> updateNomenclatureCategory(@RequestBody @Valid NomenclatureCategoryRequest request) {
        return ResponseEntity.ok(service.updateNomenclatureCategory(request));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteNomenclatureCategoryById(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(service.deleteNomenclatureCategoryById(categoryId));
    }

}
