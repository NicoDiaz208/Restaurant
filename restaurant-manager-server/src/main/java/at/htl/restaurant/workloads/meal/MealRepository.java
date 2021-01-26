package at.htl.restaurant.workloads.meal;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.*;

@RequestScoped
public class MealRepository implements IMealRepository{
    private final EntityManager entityManager;

    public MealRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Meal getMealById(Integer mealId)
    {
        var query = entityManager.createQuery("select m from Meal m where  m.mealId = :mealId", Meal.class);
        query.setParameter("mealId", mealId);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public MealItem getMealItemById(MealItemId id) {
        var query = entityManager.createQuery("select mi from MealItem mi " +
                "where mi.id.ingredient.ingredientId = :ingredientId and mi.id.meal.mealId = :mealId",MealItem.class);
        query.setParameter("ingredientId", id.getIngredient().getIngredientId());
        query.setParameter("mealId", id.getMeal().getMealId());
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addMeal (Meal newMeal){
        entityManager.persist(newMeal);
    }

    @Override
    public void deleteMeal(Meal deleteMeal){
        entityManager.remove(deleteMeal);
    }

    @Override
    public void addMealItem(MealItem newMealItem){
        entityManager.persist(newMealItem);
    }


    @Override
    public void deleteMealItem(MealItem deleteMealItem)
    {
        entityManager.remove(deleteMealItem);
    }
    @Override
    public List<Meal> getAllMeals(){
        var query = entityManager.createQuery("select m from Meal m");
        return query.getResultList();
    }

    @Override
    public List<MealItem> getAllMealItems(Meal meal){
        var query = entityManager.createQuery("select m from MealItem m where m.id.meal.mealId = :mealId");
        query.setParameter("mealId", meal.getMealId());
        return query.getResultList();
    }
}