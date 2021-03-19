package assignment_4_recipe_app;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IngredientStore {
  static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

  public void getSavedIngredients() {
    JSONArray ingredientsFromJson = RecipeHandleFile.readIngredients();
    for (int i = 0; i < ingredientsFromJson.length(); i++) {
      JSONObject ingredient = ingredientsFromJson.getJSONObject(i);
      Ingredient newIngredient = new Ingredient();
      newIngredient.setName(ingredient.get("name").toString());
      newIngredient.setUnit(ingredient.get("unit").toString());
      newIngredient.setPrice(ingredient.getDouble("price"));
      ingredientList.add(newIngredient);
    }
  }

  public ArrayList<Ingredient> getAllIngredients() {
    return ingredientList;
  }

  public static Ingredient getIngredientByName(String name) {
    for (int i = 0; i < ingredientList.size(); i++) {
      if (ingredientList.get(i).name.equals(name)) {
        return ingredientList.get(i);
      }
    }
    return null;
  }

  public void addIngredient(Ingredient newIngredient) {
    ingredientList.add(newIngredient);
  }

  public static void removeIngredientByName(String name) {
    for (int i = 0; i < ingredientList.size(); i++) {
      if (ingredientList.get(i).name.equals(name)) {
        ingredientList.remove(i);
      }
    }
  }
}
