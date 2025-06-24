package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryResponse;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import com.expertise.ebudget.budget.service.NomenclatureService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/nomenclatures")
@CrossOrigin(origins = "*")
public class NomenclatureController {

    private final NomenclatureService service;

    @PostMapping
    public ResponseEntity<Long> createNomenclature(@RequestBody @Valid NomenclatureRequest request){
        return ResponseEntity.ok(service.createNomenclature(request));
    }

    @GetMapping
    public ResponseEntity<List<NomenclatureResponse>> getAllNomenclatures(){
        return ResponseEntity.ok(service.getAllNomenclatures());
    }

    @GetMapping("/{nomenclatureId}")
    public ResponseEntity<NomenclatureResponse> getNomenclatureById(@PathVariable("nomenclatureId") Long nomenclatureId){
        return ResponseEntity.ok(service.getNomenclatureById(nomenclatureId));
    }

    @PutMapping
    public ResponseEntity<NomenclatureResponse> updateNomenclature(@RequestBody @Valid NomenclatureRequest request) {
        return ResponseEntity.ok(service.updateNomenclature(request));
    }

    @DeleteMapping("/{nomenclatureId}")
    public ResponseEntity<String> deleteNomenclatureById(@PathVariable("nomenclatureId") Long nomenclatureId){
        return ResponseEntity.ok(service.deleteNomenclatureById(nomenclatureId));
    }

    @GetMapping("/category/{categoryId}")
    private ResponseEntity<List<NomenclatureResponse>> getNomenclaturesByCategory(@PathVariable("categoryId") long categoryId){
        return ResponseEntity.ok(service.getNomenclaturesByCategory(categoryId));
    }
}
