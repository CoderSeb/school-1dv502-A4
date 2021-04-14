package assignment_4_recipe_app.search;

import java.util.ArrayList;
import java.util.Scanner;

import assignment_4_recipe_app.Ingredient;
import assignment_4_recipe_app.Recipe;
import assignment_4_recipe_app.RecipeApp;
import assignment_4_recipe_app.RecipeHandleConsole;

public class SearchByIngredient implements SearchStrategy {
  Scanner searchScan = new Scanner(System.in);

  @Override
  public void search(ArrayList<Recipe> recipes) {
    String input = RecipeHandleConsole.promptRecipeSearchIngredient();
    Ingredient ingredient = RecipeApp.ingredients.getIngredientByName(input);
    recipes.removeIf(recipe -> !recipe.getIngredients().contains(ingredient));
  }
}
