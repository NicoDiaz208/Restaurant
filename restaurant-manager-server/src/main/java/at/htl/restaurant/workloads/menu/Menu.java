package at.htl.restaurant.workloads.menu;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {
    @Id
    private Short menuId;
    private String title;

    @OneToMany(mappedBy = "id.menu", cascade = {CascadeType.PERSIST})
    private List<MenuItem> menuItemList;

    public Menu(Short menuId, String title) {
        this.menuId = menuId;
        this.title = title;
    }

    public Menu() {

    }

    public Short getMenuId() {
        return menuId;
    }

    public void setMenuId(Short menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
