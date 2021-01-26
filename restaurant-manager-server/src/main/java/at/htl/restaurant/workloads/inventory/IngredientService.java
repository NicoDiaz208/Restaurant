package at.htl.restaurant.workloads.inventory;

import at.htl.restaurant.model.IngredientDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class IngredientService implements IIngredientService {
    private final IInventoryRepository inventoryRepository;

    public IngredientService(IInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public boolean addIngredient(IngredientDTO newIngredient) {
        var existingIngredient = inventoryRepository.getIngredientById(newIngredient.getIngredientId());
        if(existingIngredient != null)
            return false;

        var ingredient = new Ingredient();
        ingredient.setIngredientId(newIngredient.getIngredientId());
        ingredient.setName(newIngredient.getName());
        ingredient.setPrice(newIngredient.getPrice());
        inventoryRepository.addIngredient(ingredient);
        return true;
    }

    @Override
    public boolean removeIngredient(IngredientDTO removeIngredient) {
        var existingIngredient = inventoryRepository.getIngredientById(removeIngredient.getIngredientId());
        if(existingIngredient == null)
            return false;

        inventoryRepository.removeIngredient(existingIngredient);
        return true;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return inventoryRepository.getAllIngredients();
    }
}
