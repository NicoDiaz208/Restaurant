package at.htl.restaurant.api;

import at.htl.restaurant.model.IngredientDTO;
import at.htl.restaurant.model.InventoryDTO;
import at.htl.restaurant.workloads.inventory.IIngredientService;
import at.htl.restaurant.workloads.inventory.IInventoryService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/api/inventory")
public class InventoryResource {

    private final IInventoryService inventoryService;
    private final IIngredientService ingredientService;

    public InventoryResource(IInventoryService inventoryService, IIngredientService ingredientService) {
        this.inventoryService = inventoryService;
        this.ingredientService = ingredientService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInventories(){
        var inventories = inventoryService.getAllInventories();

        return Response.ok(inventories).build();
    }

    @GET
    @Path("ingredient/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIngredients(){
        var ingredients = ingredientService.getAllIngredients();

        return Response.ok(ingredients).build();
    }

    @POST
    @Transactional
    @Path("ingredient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addIngredient(IngredientDTO ingredientDTO){
        var result = ingredientService.addIngredient(ingredientDTO);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @DELETE
    @Path("ingredient")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeIngredient(IngredientDTO ingredientDTO){
        var result = ingredientService.removeIngredient(ingredientDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInventory(InventoryDTO inventoryDTO){
        var result = inventoryService.addInventory(inventoryDTO);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
