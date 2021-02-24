package at.htl.restaurant.workloads.menu;

import at.htl.restaurant.model.MenuDTO;
import at.htl.restaurant.model.MenuItemDTO;
import at.htl.restaurant.workloads.meal.IMealRepository;

import javax.enterprise.context.RequestScoped;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class MenuService implements IMenuService {
    private final IMenuRepository menuRepository;
    private final IMealRepository mealRepository;

    public MenuService(IMenuRepository menuRepository, IMealRepository mealRepository) {
        this.menuRepository = menuRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public boolean addMenu(MenuDTO newMenu) {
        var menu = new Menu();
        menu.setMenuId(newMenu.getMenuId());
        menu.setTitle(newMenu.getTitle());
        menuRepository.addMenu(menu);
        return true;
    }

    @Override
    public boolean removeMenu(MenuDTO removeMenu) {
        var menu = new Menu();
        menu.setMenuId(removeMenu.getMenuId());
        menu.setTitle(removeMenu.getTitle());
        menuRepository.removeMenu(menu);
        return true;
    }

    @Override
    public boolean addMenuItem(MenuItemDTO newMenuItem) {
        var existingMenu = menuRepository.getMenuById(newMenuItem.getMenuId());
        var existingMeal =  mealRepository.getMealById(newMenuItem.getMealId());
        if(existingMeal == null || existingMenu == null)
            return false;

        var existingMenuItem = menuRepository.getMenuItemById(new MenuItemId(existingMenu, existingMeal));
        if(existingMenuItem != null)
            return false;

        var menuItem = new MenuItem();
        menuItem.setId(new MenuItemId(existingMenu, existingMeal));
        menuRepository.addMenuItem(menuItem);
        return true;
    }

    @Override
    public boolean removeMenuItem(MenuItemDTO removeMenuItem) {
        var existingMenu = menuRepository.getMenuById(removeMenuItem.getMenuId());
        var existingMeal =  mealRepository.getMealById(removeMenuItem.getMealId());
        if(existingMeal == null || existingMenu == null)
            return false;

        var existingMenuItem = menuRepository.getMenuItemById(new MenuItemId(existingMenu, existingMeal));
        if(existingMenuItem == null)
            return false;

        var menuItem = new MenuItem();
        menuItem.setId(existingMenuItem.getId());
        menuRepository.removeMenuItem(menuItem);
        return true;
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        var result = new ArrayList<MenuDTO>();
        var items = menuRepository.getAllMenuItems();

        menuRepository.getAllMenus().forEach(i -> {
            var menuDTO = new MenuDTO();
            var mItems = new ArrayList<MenuItemDTO>();
            items.forEach(m -> {
                mItems.add(new MenuItemDTO(m.getId().getMenu().getMenuId(), m.getId().getMeal().getMealId()));
            });
            menuDTO.setMenuItems(mItems);
            menuDTO.setMenuId(i.getMenuId());
            menuDTO.setTitle(i.getTitle());
            result.add(menuDTO) ;
        });
        return result;
    }
}
