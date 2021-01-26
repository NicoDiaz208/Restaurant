package at.htl.restaurant.workloads.meal;

import at.htl.restaurant.workloads.inventory.Ingredient;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealItemId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "mealId")
    private Meal meal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealItemId that = (MealItemId) o;
        return Objects.equals(ingredient.getIngredientId(), that.ingredient.getIngredientId()) &&
                Objects.equals(meal.getMealId(), that.meal.getMealId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient.getIngredientId(), meal.getMealId());
    }

    public MealItemId() {
    }

    public MealItemId(Ingredient ingredient, Meal meal) {
        this.ingredient = ingredient;
        this.meal = meal;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
