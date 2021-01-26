package at.htl.restaurant.workloads.menu;

import java.util.List;

public interface IMenuRepository {
    public void addMenu(Menu menu);
    public void addMenuItem(MenuItem menuItem);
    public void removeMenu(Menu menu);
    public void removeMenuItem(MenuItem menuItem);
    public List<Menu> getAllMenus();
    public List<MenuItem> getAllMenuItems();
    public MenuItem getMenuItemById(MenuItemId id);
    public Menu getMenuById(Short id);
}
