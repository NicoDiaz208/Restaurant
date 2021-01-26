package at.htl.restaurant.workloads.meal;

import at.htl.restaurant.model.MealDTO;
import at.htl.restaurant.model.MealItemDTO;
import at.htl.restaurant.workloads.inventory.IInventoryRepository;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class MealService implements IMealService {

    private final IMealRepository mealRepository;
    private final IInventoryRepository inventoryRepository;

    public MealService(IMealRepository mealRepository, IInventoryRepository inventoryRepository) {
        this.mealRepository = mealRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public boolean addMeal(MealDTO newMeal) {
        var existingMeal = mealRepository.getMealById(newMeal.getMealId());
        if(existingMeal != null)
            return false;

        var meal = new Meal();
        meal.setMealId(newMeal.getMealId());
        meal.setDescription(newMeal.getDesc());
        meal.setName(newMeal.getName());
        mealRepository.addMeal(meal);
        return true;
    }

    @Override
    public boolean addMealItem(MealItemDTO newMealItem) {
        var existingIngredient = inventoryRepository.getIngredientById(newMealItem.getIngredientId());
        var existingMeal = mealRepository.getMealById(newMealItem.getMealId());

        if(existingIngredient == null || existingMeal == null)
            return false;

        var existingMealItem = mealRepository.getMealItemById(new MealItemId(existingIngredient, existingMeal));
        if(existingMealItem != null)
            return false;

        var mealItem = new MealItem();
        mealItem.setId(new MealItemId(existingIngredient, existingMeal));
        mealItem.setAmount(newMealItem.getAmount());
        mealRepository.addMealItem(mealItem);
        return true;
    }

    @Override
    public boolean deleteMealItem(MealItemDTO deleteMealItem) {
        var existingIngredient = inventoryRepository.getIngredientById(deleteMealItem.getIngredientId());
        var existingMeal = mealRepository.getMealById(deleteMealItem.getMealId());

        var existingMealItem = mealRepository.getMealItemById(new MealItemId(existingIngredient, existingMeal));
        if(existingMealItem == null)
            return false;

        var mealItem = new MealItem();
        mealItem.setId(new MealItemId(existingIngredient, existingMeal));
        mealItem.setAmount(deleteMealItem.getAmount());
        mealRepository.deleteMealItem(mealItem);
        return true;
    }

    @Override
    public boolean deleteMeal(Meal deleteMeal) {
        var existingMeal = mealRepository.getMealById(deleteMeal.getMealId());
        if(existingMeal == null)
            return false;

        var meal = new Meal();
        meal.setMealId(deleteMeal.getMealId());
        meal.setDescription(deleteMeal.getDescription());
        meal.setName(deleteMeal.getName());
        mealRepository.addMeal(meal);
        return true;
    }

    @Override
    public List<MealDTO> getAllMeals() {
        var result = new ArrayList<MealDTO>();
        for (Meal item : mealRepository.getAllMeals()) {
            var items = new ArrayList<MealItemDTO>();
            for (var i: mealRepository.getAllMealItems(item)) {
                items.add(new MealItemDTO(item.getMealId(), i.getAmount(), i.getId().getIngredient().getIngredientId(), i.isAvailable()));
            }
            result.add(new MealDTO(item.getMealId(), item.getName(), item.getDescription(), items.toArray(MealItemDTO[]::new)));
        }
        return result;
    }
}
