package at.htl.restaurant.workloads.meal;

import java.util.*;

public interface IMealRepository {
    public Meal getMealById(Integer mealId);
    public MealItem getMealItemById(MealItemId id);
    public void addMeal (Meal newMeal);
    public void deleteMeal(Meal deleteMeal);
    public void addMealItem(MealItem newMealItem);
    public void deleteMealItem(MealItem deleteMealItem);
    public List<Meal> getAllMeals();
    public List<MealItem> getAllMealItems(Meal meal);
}
