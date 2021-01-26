package at.htl.restaurant.workloads.menu;

import at.htl.restaurant.model.MenuDTO;
import at.htl.restaurant.model.MenuItemDTO;

import java.util.*;

public interface IMenuService {
    public boolean addMenu(MenuDTO newMenu);
    public boolean removeMenu(MenuDTO removeMenu);
    public boolean addMenuItem(MenuItemDTO newMenuItem);
    public boolean removeMenuItem(MenuItemDTO removeMenuItem);
    public List<MenuDTO> getAllMenus();
}
