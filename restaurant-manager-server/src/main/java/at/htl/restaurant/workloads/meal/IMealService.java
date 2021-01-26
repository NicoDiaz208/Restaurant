package at.htl.restaurant.workloads.meal;

import at.htl.restaurant.model.MealDTO;
import at.htl.restaurant.model.MealItemDTO;
import java.util.*;

public interface IMealService {
    public boolean addMeal(MealDTO newMeal);
    public boolean addMealItem(MealItemDTO newMealItem);
    public boolean deleteMealItem(MealItemDTO deleteMealItem);
    public boolean deleteMeal(Meal deleteMeal);
    public List<MealDTO> getAllMeals();
}