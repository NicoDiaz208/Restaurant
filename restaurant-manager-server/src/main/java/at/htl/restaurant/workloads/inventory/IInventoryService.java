package at.htl.restaurant.workloads.inventory;

import at.htl.restaurant.model.InventoryDTO;

import java.util.*;

public interface IInventoryService {
    boolean addInventory(InventoryDTO newInventory);
    List<Inventory> getAllInventories();
}
