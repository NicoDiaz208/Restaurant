package at.htl.restaurant.workloads.meal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MealItem {
    @Id
    private MealItemId id;
    private Integer amount;
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MealItem() {
    }

    public MealItem(MealItemId id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public MealItemId getId() {
        return id;
    }

    public void setId(MealItemId id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
