package com.expertise.ebudget.budget.entity.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecipeStatus {
    VALIDATED("Validated"),
    PENDING("Pending");

    private final String status;

    public static RecipeStatus fromStatus(String status){
        for (RecipeStatus recipeStatus : RecipeStatus.values()){
            if (recipeStatus.getStatus().equalsIgnoreCase(status)){
                return recipeStatus;
            }
        }
        throw new IllegalArgumentException("No status for : " + status);
    }

}
