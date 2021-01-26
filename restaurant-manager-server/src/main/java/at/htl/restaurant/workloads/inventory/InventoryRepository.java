package at.htl.restaurant.workloads.inventory;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.*;

@RequestScoped
public class InventoryRepository implements IInventoryRepository{
    private final EntityManager entityManager;

    public InventoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Inventory> getAllInventories() {
        var query = entityManager.createQuery("select  i from Inventory i");
        return query.getResultList();
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        var query = entityManager.createQuery("select i from Inventory i");
        return query.getResultList();
    }



    @Override
    public void addIngredient(Ingredient ingredient) {
       entityManager.persist(ingredient);
    }

    @Override
    public void addInventory(Inventory inventory) {
        inventory.setInventoryId(null);
        entityManager.persist(inventory);
    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        entityManager.remove(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Integer id) {
        var query = entityManager.createQuery("select i from Ingredient i where  i.ingredientId = :id",Ingredient.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Inventory getInventoryById(Integer id) {
        var query = entityManager.createQuery("select i from Inventory i where  i.inventoryId = :id", Inventory.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
}
