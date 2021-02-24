package at.htl.restaurant.workloads.order;

import at.htl.restaurant.model.OrderDTO;
import at.htl.restaurant.model.OrderItemDTO;
import java.util.*;

public interface IOrderService {
    public boolean addOrder(OrderDTO newOrder);
    public boolean addOrderItem(OrderItemDTO newOrderItem);
    public boolean removeOrderItem(OrderItemDTO removeOrderItem);
    public List<OrderDTO> getAllOrders();
}
