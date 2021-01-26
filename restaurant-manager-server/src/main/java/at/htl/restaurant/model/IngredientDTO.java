package at.htl.restaurant.model;

import java.math.BigDecimal;

public class IngredientDTO {
    private Integer ingredientId;
    private String name;
    private BigDecimal price;

    public IngredientDTO() {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
