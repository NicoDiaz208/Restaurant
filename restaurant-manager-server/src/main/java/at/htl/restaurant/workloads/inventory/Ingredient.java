package at.htl.restaurant.workloads.inventory;

import at.htl.restaurant.workloads.meal.MealItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    private Integer ingredientId;
    private String name;
    private BigDecimal price;

    @OneToOne
    private Inventory inventory;

    @OneToMany(mappedBy = "id.ingredient", cascade = {CascadeType.PERSIST})
    private List<MealItem> mealItems;

    public Ingredient() {
    }

    public Ingredient(Integer ingredientId, String name, BigDecimal price) {
    }

    public Ingredient(Integer ingredientId, String name, BigDecimal price, Inventory inventory, List<MealItem> mealItems) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.mealItems = mealItems;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
