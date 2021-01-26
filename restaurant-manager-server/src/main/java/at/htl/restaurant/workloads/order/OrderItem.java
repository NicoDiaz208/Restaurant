package at.htl.restaurant.workloads.order;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemId id;
    private Integer amount;

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
