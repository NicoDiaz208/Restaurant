package at.htl.restaurant.workloads.menu;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MenuItem {
    @EmbeddedId
    private MenuItemId id;

    public MenuItem(MenuItemId id, Menu menu) {
        this.id = id;
    }

    public MenuItem() {

    }

    public MenuItemId getId() {
        return id;
    }

    public void setId(MenuItemId id) {
        this.id = id;
    }
}
