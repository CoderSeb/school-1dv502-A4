package assignment_4_recipe_app;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecipeBook {
  static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

  public void getSavedRecipes() {
    JSONArray recipesFromJson = RecipeHandleFile.readRecipes();
    for (int i = 0; i < recipesFromJson.length(); i++) {
      JSONObject recipe = recipesFromJson.getJSONObject(i);
      String name = recipe.get("name").toString();
      int portions = (int) recipe.get("portions");
      Recipe newRecipe = new Recipe(name, portions);

      JSONArray ingredients = (JSONArray) recipe.get("ingredients");
      for (int n = 0; n < ingredients.length(); n++) {
        String ingredientName = ingredients.getJSONObject(i).get("name").toString();
        String ingredientUnit = ingredients.getJSONObject(i).get("unit").toString();
        Double ingredientTotalPrice = (Double) ingredients.getJSONObject(i).get("totalPrice");
        int ingredientAmount = (int) ingredients.getJSONObject(i).get("amount");
        newRecipe
            .addIngredient(ingredientName + ":" + ingredientAmount + " " + ingredientUnit + ":" + ingredientTotalPrice);
      }

      JSONArray instructions = (JSONArray) recipe.get("instructions");
      for (int n = 0; n < instructions.length(); n++) {
        newRecipe.addInstruction(instructions.getJSONObject(n).toString());
      }

      JSONArray comments = (JSONArray) recipe.get("comments");
      for (int n = 0; n < comments.length(); n++) {
        newRecipe.addComment(comments.getJSONObject(n).toString());
      }

      recipeList.add(newRecipe);
    }
  }

  public ArrayList<Recipe> getAllRecipes() {
    return recipeList;
  }

  public static Recipe getRecipeByName(String name) {
    for (int i = 0; i < recipeList.size(); i++) {
      if (recipeList.get(i).name.equals(name)) {
        return recipeList.get(i);
      }
    }
    return null;
  }

  public static void removeRecipeByName(String name) {
    for (int i = 0; i < recipeList.size(); i++) {
      if (recipeList.get(i).name == name) {
        recipeList.remove(i);
      }
    }
  }
}
