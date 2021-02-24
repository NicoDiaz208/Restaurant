package at.htl.restaurant.api;

import at.htl.restaurant.model.MealDTO;
import at.htl.restaurant.workloads.meal.IMealService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/meal")
public class MealResource {
    private final IMealService mealService;

    public MealResource(IMealService mealService) {
        this.mealService = mealService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMeals() {
        var result = mealService.getAllMeals();
        return Response.ok(result).build();
    }

    @Transactional
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response addMeal(MealDTO mealDTO){
        var result = mealService.addMeal(mealDTO);
        if(result)
            for (var item : mealDTO.getMealItems()) {
                if(result)
                    result = mealService.addMealItem(item);
            }


        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
