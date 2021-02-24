package at.htl.restaurant.workloads.order;

import at.htl.restaurant.model.OrderDTO;
import at.htl.restaurant.model.OrderItemDTO;

import java.util.*;

public interface IOrderRepository {
    public void addOrder(Order order);
    public void addOrderItem(OrderItem order);
    public void removeOrderItem(OrderItem removeOrderItem);
    public List<Order> getAllOrders();
    public Order getOrderById(Integer id);
    public OrderItem getOrderItemById(OrderItemId id);
    public List<OrderItem> getAllOrderItems();
}
