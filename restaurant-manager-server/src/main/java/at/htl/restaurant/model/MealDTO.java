package at.htl.restaurant.model;

import java.util.*;

public class MealDTO {
    private Integer mealId;
    private String name;
    private String desc;
    private MealItemDTO[] mealItems;

    public MealDTO() {
    }

    public MealDTO(Integer mealId, String name, String desc, MealItemDTO[] mealItems) {
        this.mealId = mealId;
        this.name = name;
        this.desc = desc;
        this.mealItems = mealItems;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public MealItemDTO[] getMealItems() {
        return mealItems;
    }

    public void setMealItems(MealItemDTO[] mealItems) {
        this.mealItems = mealItems;
    }
}