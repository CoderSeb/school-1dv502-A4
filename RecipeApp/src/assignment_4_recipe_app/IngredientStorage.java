package assignment_4_recipe_app;

import java.util.ArrayList;

public class IngredientStorage {
  ArrayList<Ingredient> ingredientStorage;

  public void addIngredient(Ingredient newIngredient) {
    ingredientStorage.add(newIngredient);
  }

  public void removeIngredient(String ingredientName) {
    for (int i = 0; i < ingredientStorage.size(); i++) {
      if (ingredientStorage.get(i).name == ingredientName) {
        ingredientStorage.remove(i);
      }
    }
  }
}
