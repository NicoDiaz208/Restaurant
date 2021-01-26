package at.htl.restaurant.workloads.inventory;

import at.htl.restaurant.model.IngredientDTO;
import java.util.*;

public interface IIngredientService {
    public boolean addIngredient(IngredientDTO newIngredient);
    public boolean removeIngredient(IngredientDTO removeIngredient);
    public List<Ingredient> getAllIngredients();
}
