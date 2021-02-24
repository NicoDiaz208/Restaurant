package at.htl.restaurant.workloads.order;

import at.htl.restaurant.model.OrderDTO;
import at.htl.restaurant.model.OrderItemDTO;
import at.htl.restaurant.workloads.meal.IMealRepository;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;
    private final IMealRepository mealRepository;

    public OrderService(IOrderRepository orderRepository, IMealRepository mealRepository) {
        this.orderRepository = orderRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public boolean addOrder(OrderDTO newOrder) {
        var existingOrder = orderRepository.getOrderById(newOrder.getOrderId());
        if(existingOrder != null)
            return false;

        var order = new Order();
        order.setOrderId(newOrder.getOrderId());
        orderRepository.addOrder(order);
        return true;
    }

    @Override
    public boolean addOrderItem(OrderItemDTO newOrderItem) {
        var existingOrder = orderRepository.getOrderById(newOrderItem.getOrderId());
        var existingMeal = mealRepository.getMealById(newOrderItem.getMealId());
        if(existingOrder == null || existingMeal == null)
            return false;

        var orderItem = new OrderItem();
        orderItem.setAmount(newOrderItem.getAmount());
        orderItem.setId(new OrderItemId(existingMeal, existingOrder));
        orderRepository.addOrderItem(orderItem);
        return true;
    }

    @Override
    public boolean removeOrderItem(OrderItemDTO removeOrderItem) {
        var existingOrder = orderRepository.getOrderById(removeOrderItem.getOrderId());
        var existingMeal = mealRepository.getMealById(removeOrderItem.getMealId());
        if(existingOrder == null || existingMeal == null)
            return false;

        var orderItem = new OrderItem();
        orderItem.setAmount(removeOrderItem.getAmount());
        orderItem.setId(new OrderItemId(existingMeal, existingOrder));
        orderRepository.removeOrderItem(orderItem);
        return true;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        var result = new ArrayList<OrderDTO>();
        var orderItems = orderRepository.getAllOrderItems();

        orderRepository.getAllOrders().forEach(o -> {
            var items = new ArrayList<OrderItemDTO>();

            orderItems.forEach(oi -> {
                items.add(new OrderItemDTO(oi.getId().getMealToOrder().getMealId(), oi.getId().getOrder().getOrderId(), oi.getAmount()));
            });

            var orderToAdd = new OrderDTO();
            orderToAdd.setOrderId(o.getOrderId());
            orderToAdd.setOrderItems(items);

            result.add(orderToAdd);
        });
        return result;
    }
}
