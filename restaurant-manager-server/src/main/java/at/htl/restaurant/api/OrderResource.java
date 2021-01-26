package at.htl.restaurant.api;

import at.htl.restaurant.model.OrderDTO;
import at.htl.restaurant.workloads.order.IOrderService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/order")
public class OrderResource {

    private final IOrderService orderService;

    public OrderResource(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(){
        var result =  orderService.getAllOrders();
        return Response.ok(result).build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(OrderDTO orderDTO){
        var result = orderService.addOrder(orderDTO);
        if(result){
            for (var item : orderDTO.getOrderItems()) {
                result = orderService.addOrderItem(item);
            }
        }

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();

    }
}
