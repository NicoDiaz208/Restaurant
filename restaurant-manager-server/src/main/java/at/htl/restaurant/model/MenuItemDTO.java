package at.htl.restaurant.model;

public class MenuItemDTO {
    private Short menuId;
    private Integer mealId;

    public MenuItemDTO() {
    }

    public MenuItemDTO(Short menuId, Integer mealId) {
        this.menuId = menuId;
        this.mealId = mealId;
    }

    public Short getMenuId() {
        return menuId;
    }

    public void setMenuId(Short menuId) {
        this.menuId = menuId;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }
}
