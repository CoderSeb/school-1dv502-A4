package assignment_4_recipe_app.search;

import java.util.ArrayList;
import java.util.Scanner;

import assignment_4_recipe_app.Recipe;
import assignment_4_recipe_app.RecipeHandleConsole;

public class SearchByCost implements SearchStrategy {
  Scanner searchScan = new Scanner(System.in);

  @Override
  public void search(ArrayList<Recipe> recipes) {
    Double input = RecipeHandleConsole.promptRecipeSearchMaxPrice();
    recipes.removeIf(recipe -> recipe.getCost() > input);
  }
}
