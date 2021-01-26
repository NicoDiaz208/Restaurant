package at.htl.restaurant.workloads.order;
import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table(name="\"order\"")
public class Order {
    @Id
    private Integer orderId;

    @OneToMany(mappedBy = "id.order", cascade = {CascadeType.PERSIST})
    private List<OrderItem> orderItems;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
