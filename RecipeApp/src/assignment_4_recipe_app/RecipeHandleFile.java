package assignment_4_recipe_app;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class RecipeHandleFile {
  @SuppressWarnings("unchecked")
  static File recipeFile = new File("./files/recipes.json");
  static File ingredientFile = new File("./files/ingredients.json");

  public static void checkFiles() {
    try {
      if (recipeFile.exists()) {
        System.out.println("Found a recipe file!");
      } else {
        System.out.println("A recipe file does not exist...\nCreating one...");
        recipeFile.getParentFile().mkdirs();
        if (recipeFile.createNewFile()) {
          System.out.println("File created: " + recipeFile.getName());
        }
      }
      if (ingredientFile.exists()) {
        System.out.println("Found an ingredient file!");
      } else {
        System.out.println("An ingredient file does not exist...\nCreating one...");
        ingredientFile.getParentFile().mkdirs();
        if (ingredientFile.createNewFile()) {
          System.out.println("File created: " + ingredientFile.getName());
        }
      }
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }

  public static void writeToRecipe(String newRecipeName) {
    Recipe newRecipe = new Recipe(newRecipeName);
    JSONObject recipeDetails = new JSONObject();
    recipeDetails.put("name", newRecipe.name);
    JSONObject recipeObject = new JSONObject();
    recipeObject.put("recipe", recipeDetails);
    JSONArray recipeList = new JSONArray();
    recipeList.put(recipeObject);
    try {
      FileWriter recipeFile = new FileWriter("./files/recipes.json");
      recipeFile.write(recipeList.toString());
      recipeFile.close();
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }

  public static void readRecipes() {

  }
}
