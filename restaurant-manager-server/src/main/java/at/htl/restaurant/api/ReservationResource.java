package at.htl.restaurant.api;

import at.htl.restaurant.model.ReservationDTO;
import at.htl.restaurant.model.TableDTO;
import at.htl.restaurant.workloads.reservation.IPersonService;
import at.htl.restaurant.workloads.reservation.IReservationService;
import at.htl.restaurant.workloads.reservation.ITableService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/reservation")
public class ReservationResource {

    private final ITableService tableService;
    private final IReservationService reservationService;
    private final IPersonService personService;

    public ReservationResource(ITableService tableService, IReservationService reservationService, IPersonService personService) {
        this.tableService = tableService;
        this.reservationService = reservationService;
        this.personService = personService;
    }


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMenus() {
        var result = reservationService.getAllReservations();
        return Response.ok(result).build();
    }

    @Transactional
    @POST
    public Response addReservation(ReservationDTO reservationDTO){
        personService.addPerson(reservationDTO.getPerson());
        var result = reservationService.addReservation(reservationDTO);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @DELETE
    public Response removeReservation(ReservationDTO reservationDTO){
        var result = reservationService.removeReservation(reservationDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @DELETE
    @Path("table")
    public Response removeTable(TableDTO tableDTO){
        var result = tableService.removeTable(tableDTO);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }
    @Transactional
    @POST
    @Path("table")
    public Response addTable(TableDTO tableDTO){
        var result = tableService.addTable(tableDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

}
