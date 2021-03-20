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
      Recipe newRecipe = new Recipe();
      newRecipe.setName(recipe.get("name").toString());
      newRecipe.setNumberOfPortions(recipe.getInt("portions"));
      JSONArray ingredients = (JSONArray) recipe.get("ingredients");
      for (int n = 0; n < ingredients.length(); n++) {
        String ingredientName = ingredients.getJSONObject(n).get("name").toString();
        Ingredient newIngredient = RecipeApp.ingredients.getIngredientByName(ingredientName);
        if (newIngredient != null) {
          newRecipe.addIngredient(newIngredient);
        }
      }

      JSONArray instructions = recipe.getJSONArray("instructions");
      for (int n = 0; n < instructions.length(); n++) {
        newRecipe.addInstruction(instructions.getString(n));
      }

      JSONArray comments = recipe.getJSONArray("comments");
      for (int n = 0; n < comments.length(); n++) {
        newRecipe.addComment(comments.getString(n));
      }

      recipeList.add(newRecipe);
    }
  }

  public ArrayList<Recipe> getAllRecipes() {
    return recipeList;
  }

  public void addRecipe(Recipe newRecipe) {
    recipeList.add(newRecipe);
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
