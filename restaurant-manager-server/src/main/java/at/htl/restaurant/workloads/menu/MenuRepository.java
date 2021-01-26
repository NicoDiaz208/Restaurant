package at.htl.restaurant.workloads.menu;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class MenuRepository implements IMenuRepository {
    private final EntityManager entityManager;

    public MenuRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addMenu(Menu menu) {
        entityManager.persist(menu);
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        entityManager.persist(menuItem);
    }

    @Override
    public void removeMenu(Menu menu) {
        entityManager.remove(menu);
    }

    @Override
    public void removeMenuItem(MenuItem menuItem) {
        entityManager.remove(menuItem);
    }

    @Override
    public List<Menu> getAllMenus() {
        var query = entityManager.createQuery("select m from Menu m");
        return query.getResultList();
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        var query = entityManager.createQuery("select mi from MenuItem mi");
        return query.getResultList();
    }

    @Override
    public MenuItem getMenuItemById(MenuItemId id) {
        var query = entityManager.createQuery("select mi from MenuItem mi where mi.id = :id", MenuItem.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Menu getMenuById(Short id) {
        var query = entityManager.createQuery("select m from Menu m where m.menuId = :id",Menu.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
}
