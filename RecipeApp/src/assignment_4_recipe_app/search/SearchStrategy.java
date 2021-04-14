package assignment_4_recipe_app.search;

import java.util.ArrayList;

import assignment_4_recipe_app.Recipe;

public interface SearchStrategy {
  void search(ArrayList<Recipe> recipes);
}
