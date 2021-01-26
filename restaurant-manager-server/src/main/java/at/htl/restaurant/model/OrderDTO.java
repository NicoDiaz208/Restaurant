package at.htl.restaurant.model;

import java.util.*;

public class OrderDTO {
    private Integer orderId;
    private List<OrderItemDTO> orderItems;

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
