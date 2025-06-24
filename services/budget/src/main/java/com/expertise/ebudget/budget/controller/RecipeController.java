package com.expertise.ebudget.budget.controller;

import com.expertise.ebudget.budget.entity.activity.ActivityRequest;
import com.expertise.ebudget.budget.entity.activity.ActivityResponse;
import com.expertise.ebudget.budget.entity.recipe.RecipeAndBudgetFundingResponse;
import com.expertise.ebudget.budget.entity.recipe.RecipeRequest;
import com.expertise.ebudget.budget.entity.recipe.RecipeResponse;
import com.expertise.ebudget.budget.service.RecipeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {

    private final RecipeService service;

    @PostMapping
    public ResponseEntity<Long> createRecipe(@RequestBody @Valid RecipeRequest request){
        return ResponseEntity.ok(service.createRecipe(request));
    }

    @GetMapping
    public ResponseEntity<List<RecipeResponse>> getAllRecipes(){
        return ResponseEntity.ok(service.getAllRecipes());
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(service.getRecipeById(recipeId));
    }

    @GetMapping("/budget/{budgetId}")
    public ResponseEntity<List<RecipeAndBudgetFundingResponse>> getRecipesAndBudgetFundingByBudget(@PathVariable("budgetId") Long budgetId){
        return ResponseEntity.ok(service.getRecipesAndBudgetFundingByBudget(budgetId));
    }

    @PutMapping
    public ResponseEntity<RecipeResponse> updateRecipe(@RequestBody @Valid RecipeRequest request){
        return ResponseEntity.ok(service.updateRecipe(request));
    }

    @PutMapping("/confirm")
    public ResponseEntity<RecipeResponse> confirmRecipe(@RequestBody Long recipeId){
        return  ResponseEntity.ok(service.confirmRecipe(recipeId));
    }
}
