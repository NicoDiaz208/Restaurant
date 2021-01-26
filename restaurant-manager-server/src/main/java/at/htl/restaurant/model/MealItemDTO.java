package at.htl.restaurant.model;

public class MealItemDTO {
    private Integer mealId;
    private Integer amount;
    private Integer ingredientId;
    private boolean available;

    public MealItemDTO() {
    }


    public MealItemDTO(Integer mealId, Integer amount, Integer ingredientId, boolean available) {
        this.mealId = mealId;
        this.amount = amount;
        this.ingredientId = ingredientId;
        this.available = available;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}