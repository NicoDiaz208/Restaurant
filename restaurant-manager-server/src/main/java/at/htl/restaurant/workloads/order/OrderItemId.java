package at.htl.restaurant.workloads.order;

import at.htl.restaurant.workloads.meal.Meal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Table(name= "\"orderItem\"")
@Embeddable
public class OrderItemId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "mealId")
    private Meal mealToOrder;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(mealToOrder.getMealId(), that.mealToOrder.getMealId()) &&
                Objects.equals(order.getOrderId(), that.order.getOrderId());
    }

    public OrderItemId(Meal meal, Order order) {
        this.mealToOrder = meal;
        this.order = order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealToOrder.getMealId(), order.getOrderId());
    }

    public OrderItemId() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Meal getMealToOrder() {
        return mealToOrder;
    }

    public void setMealToOrder(Meal mealToOrder) {
        this.mealToOrder = mealToOrder;
    }
}
