package assignment_4_recipe_app;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecipeBook {
  private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

  public void getSavedRecipes() {
    JSONArray recipesFromJson = RecipeHandleFile.readRecipes();
    for (int i = 0; i < recipesFromJson.length(); i++) {
      JSONObject recipe = recipesFromJson.getJSONObject(i);
      Recipe newRecipe = new Recipe();
      newRecipe.setName(recipe.get("name").toString());
      newRecipe.setNumberOfPortions(recipe.getInt("portions"));
      newRecipe.setTotalCost(recipe.getDouble("cost"));
      JSONArray ingredients = (JSONArray) recipe.get("ingredients");
      for (int n = 0; n < ingredients.length(); n++) {
        String ingredientName = ingredients.getJSONObject(n).get("name").toString();
        Ingredient newIngredient = RecipeApp.ingredients.getIngredientByName(ingredientName);
        if (newIngredient != null) {
          newRecipe.addIngredient(newIngredient);
        }
      }

      JSONArray ingredientAmounts = (JSONArray) recipe.get("amounts");
      for (int n = 0; n < ingredientAmounts.length(); n++) {
        newRecipe.addIngredientAmounts(ingredientAmounts.get(n).toString());
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

  public Recipe getRecipeByName(String name) {
    for (int i = 0; i < recipeList.size(); i++) {
      if (recipeList.get(i).getName().equals(name)) {
        return recipeList.get(i);
      }
    }
    return null;
  }

  public void removeRecipeByName(String name) {
    for (int i = 0; i < recipeList.size(); i++) {
      if (recipeList.get(i).getName().equals(name)) {
        recipeList.remove(i);
      }
    }
  }
}
