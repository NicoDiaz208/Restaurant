package at.htl.restaurant.workloads.inventory;

import at.htl.restaurant.model.InventoryDTO;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class InventoryService implements IInventoryService{
    private final IInventoryRepository inventoryRepository;

    public InventoryService(IInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public boolean addInventory(InventoryDTO newInventory) {
        var existingInventory =inventoryRepository.getInventoryById(newInventory.getInventoryId());
        var existingIngredient = inventoryRepository.getIngredientById(newInventory.getIngredient().getIngredientId());
        if(existingIngredient == null ||existingInventory != null)
            return false;

        var inventory = new Inventory();
        inventory.setIngredients(existingIngredient);
        inventory.setAmount(newInventory.getAmount());
        inventory.setTime(LocalDateTime.now());
        inventory.setInventoryId(newInventory.getInventoryId());
        inventoryRepository.addInventory(inventory);
        return true;
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.getAllInventories();
    }
}
