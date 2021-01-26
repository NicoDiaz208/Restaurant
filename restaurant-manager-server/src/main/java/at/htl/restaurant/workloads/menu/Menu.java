package at.htl.restaurant.workloads.menu;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
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