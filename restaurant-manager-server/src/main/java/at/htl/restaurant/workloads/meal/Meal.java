package at.htl.restaurant.workloads.meal;

import at.htl.restaurant.workloads.menu.MenuItem;
import at.htl.restaurant.workloads.order.Order;
import at.htl.restaurant.workloads.order.OrderItem;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;

@Entity
public class Meal {
    @Id
    private Integer mealId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "id.meal", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<MealItem> mealItems;

    public Meal() {
    }

    public Meal(Integer mealId, String name, String desc) {
        this.mealId = mealId;
        this.name = name;
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }
}
