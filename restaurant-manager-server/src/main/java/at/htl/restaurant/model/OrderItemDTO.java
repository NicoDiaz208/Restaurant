package at.htl.restaurant.model;

public class OrderItemDTO {
    private Integer mealId;
    private Integer orderId;
    private Integer amount;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer mealId, Integer orderId, Integer amount) {
        this.mealId = mealId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
