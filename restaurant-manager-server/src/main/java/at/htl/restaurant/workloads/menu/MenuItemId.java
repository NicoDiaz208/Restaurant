package at.htl.restaurant.workloads.menu;

import at.htl.restaurant.workloads.meal.Meal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MenuItemId implements Serializable {

    @ManyToOne
    @JoinColumn(name="menuId")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "mealId")
    private Meal meal;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public MenuItemId() {

    }

    public MenuItemId(Menu menu, Meal meal) {
        this.menu = menu;
        this.meal = meal;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        MenuItemId menuItemId = (MenuItemId) obj;
        return Objects.equals(meal.getMealId(), menuItemId.meal.getMealId()) &&
                Objects.equals(menu.getMenuId(), menuItemId.menu.getMenuId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(meal.getMealId(), menu.getMenuId());
    }
}
