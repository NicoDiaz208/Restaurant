package at.htl.restaurant.workloads.order;

import at.htl.restaurant.model.OrderDTO;
import at.htl.restaurant.model.OrderItemDTO;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class OrderRepository implements IOrderRepository {
    private final EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void addOrder(Order newOrder) {
        entityManager.persist(newOrder);
    }

    @Override
    public void addOrderItem(OrderItem newOrderItem) {
        entityManager.persist(newOrderItem);
    }

    @Override
    public void removeOrderItem(OrderItem removeOrderItem) {
        entityManager.remove(removeOrderItem);
    }

    @Override
    public List<Order> getAllOrders() {
        var query = entityManager.createQuery("select o from Order o");
        return query.getResultList();
    }

    @Override
    public Order getOrderById(Integer id) {
        var query = entityManager.createQuery("select o from Order o where o.orderId = :id", Order.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public OrderItem getOrderItemById(OrderItemId id) {
        var query = entityManager.createQuery("select o from OrderItem o " +
                "where o.id.mealToOrder.mealId = :mealId and o.id.order.orderId = :orderId", OrderItem.class);
        query.setParameter("mealId", id.getMealToOrder().getMealId());
        query.setParameter("orderId", id.getOrder().getOrderId());
        return query.getResultStream().findFirst().orElse(null);
    }
}
