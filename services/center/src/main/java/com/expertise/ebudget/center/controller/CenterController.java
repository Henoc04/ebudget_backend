package com.expertise.ebudget.center.controller;

import com.expertise.ebudget.center.entity.CenterRequest;
import com.expertise.ebudget.center.entity.CenterResponse;
import com.expertise.ebudget.center.service.CenterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/centers")
@CrossOrigin(origins = "*")
public class CenterController {

    private final CenterService service;

    @PostMapping
    public ResponseEntity<Long> createCenter(@RequestBody @Valid CenterRequest request){
        return ResponseEntity.ok(service.createCenter(request));
    }

    @GetMapping
    public ResponseEntity<List<CenterResponse>> getAllCenters(){
        return ResponseEntity.ok(service.getAllCenters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CenterResponse> getCenter(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getCenter(id));
    }

    @PutMapping
    public ResponseEntity<CenterResponse> updateCenter(@RequestBody @Valid CenterRequest request){
        return ResponseEntity.ok(service.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCenterById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteCenterById(id));
    }
}
