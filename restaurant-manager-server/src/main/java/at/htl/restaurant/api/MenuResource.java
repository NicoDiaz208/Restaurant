package at.htl.restaurant.api;

import at.htl.restaurant.model.*;
import at.htl.restaurant.workloads.menu.IMenuService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/menu")
public class MenuResource {

    private final IMenuService menuService;

    public MenuResource(IMenuService menuService) {
        this.menuService = menuService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMenus() {
        var menus = menuService.getAllMenus();
        return Response.ok(menus).build();
    }

    @Transactional
    @POST
    public Response addMenu(MenuDTO menuDTO){
        var result = menuService.addMenu(menuDTO);
        if (result){
            for (var item : menuDTO.getMenuItems()) {
                if(result)
                    result = menuService.addMenuItem(item);
            }
        }

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @DELETE
    public Response removeMenu(MenuDTO menuDTO){
        var result = menuService.removeMenu(menuDTO);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
