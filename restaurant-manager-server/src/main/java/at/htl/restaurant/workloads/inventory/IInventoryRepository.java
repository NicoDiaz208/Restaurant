package at.htl.restaurant.workloads.inventory;

import java.util.List;

public interface IInventoryRepository {
    public List<Inventory> getAllInventories();
    public List<Ingredient> getAllIngredients();
    public void addIngredient(Ingredient ingredient);
    public void addInventory(Inventory inventory);
    public void removeIngredient(Ingredient ingredient);
    public Ingredient getIngredientById(Integer id);
    public Inventory getInventoryById(Integer id);
}
