package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.center.CenterClient;
import com.expertise.ebudget.budget.entity.center.CenterResponse;
import com.expertise.ebudget.budget.entity.recipe.RecipeAndBudgetFundingResponse;
import com.expertise.ebudget.budget.entity.recipe.RecipeRequest;
import com.expertise.ebudget.budget.entity.recipe.RecipeResponse;
import com.expertise.ebudget.budget.entity.recipe.RecipeStatus;
import com.expertise.ebudget.budget.mapper.RecipeMapper;
import com.expertise.ebudget.budget.repository.BudgetFundingRepository;
import com.expertise.ebudget.budget.repository.BudgetRepository;
import com.expertise.ebudget.budget.repository.FinancingRepository;
import com.expertise.ebudget.budget.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final BudgetRepository budgetRepository;
    private final BudgetFundingRepository budgetFundingRepository;
    private final FinancingRepository financingRepository;
    private final CenterClient centerClient;
    private final RecipeMapper mapper;

    public Long createRecipe(@Valid RecipeRequest request) {
        var budgetFunding = budgetFundingRepository.findById(request.budgetFundingId())
                .orElseThrow(()-> new EntityNotFoundException("This budget funding don't exist"));
        return repository.save(mapper.toRecipe(budgetFunding, request)).getId();
    }

    public List<RecipeResponse> getAllRecipes() {
        return repository.findAll().stream()
                .map(mapper::fromRecipe)
                .toList();
    }

    public List<RecipeAndBudgetFundingResponse> getRecipesAndBudgetFundingByBudget(Long budgetId) {
        var budget = budgetRepository.findById(budgetId)
                .orElseThrow(()-> new EntityNotFoundException("This budget don't exist"));
       return repository.findRecipesAndBudgetFundingByBudget(budgetId);
    }

    public RecipeResponse updateRecipe(@Valid RecipeRequest request) {
        var recipe = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("This recipe don't exist"));
        recipe.setName(request.name());
        recipe.setAmount(request.amount());
        repository.save(recipe);
        return mapper.fromRecipe(recipe);
    }

    public RecipeResponse getRecipeById(Long recipeId) {
        var recipe = repository.findById(recipeId)
                .orElseThrow(()-> new EntityNotFoundException("This recipe don't exist"));
        return mapper.fromRecipe(recipe);
    }

    public RecipeResponse confirmRecipe(Long recipeId) {
        var recipe = repository.findById(recipeId)
                .orElseThrow(()-> new EntityNotFoundException("This recipe don't exist"));

        var budgetFunding = budgetFundingRepository.findById(recipe.getBudgetFunding().getId())
                .orElseThrow(()-> new EntityNotFoundException("This budget funding don't exist"));

        var center = centerClient.findById(budgetFunding.getBudget().getCenterId())
                .orElseThrow(()-> new EntityNotFoundException("This center don't exist"));

        var centerAmount = center.amount().add(recipe.getAmount());
        center = new CenterResponse(
                center.id(),
                center.name(),
                center.location(),
                center.manager(),
                centerAmount,
                center.iban()
        );
        var amount = budgetFunding.getAmount().add(recipe.getAmount());
        budgetFunding.setAmount(amount);
        recipe.setStatus(RecipeStatus.VALIDATED);

        repository.save(recipe);
        centerClient.updateCenter(center);
        budgetFundingRepository.save(budgetFunding);

        return mapper.fromRecipe(recipe);
    }
}
