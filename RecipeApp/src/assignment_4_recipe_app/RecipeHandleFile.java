package assignment_4_recipe_app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
import org.json.*;

public class RecipeHandleFile {
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
    JSONArray recipeList = readRecipes();
    recipeList.put(recipeDetails);
    try {
      FileWriter recipeFile = new FileWriter("./files/recipes.json");
      recipeFile.write(recipeList.toString());
      recipeFile.close();
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }

  /**
   * Returns a JSONArray with recipes.
   * 
   * @return JSONArray.
   */
  public static JSONArray readRecipes() {
    try {
      JSONTokener jsonToken = new JSONTokener(new FileInputStream(recipeFile));
      JSONArray recipeArray = new JSONArray(jsonToken);
      return recipeArray;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Returns a JSONArray with ingredients.
   * 
   * @return JSONArray.
   */
  public static JSONArray readIngredients() {
    try {
      JSONTokener jsonToken = new JSONTokener(new FileInputStream(ingredientFile));
      JSONArray ingredientArray = new JSONArray(jsonToken);
      return ingredientArray;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void writeIngredient(Ingredient newIngredient) {
    JSONObject ingredientJson = new JSONObject();
    ingredientJson.put("name", newIngredient.name);
    ingredientJson.put("unit", newIngredient.unitOfMeasure);
    ingredientJson.put("price", newIngredient.price);
    JSONArray ingredientList = readIngredients();
    ingredientList.put(ingredientJson);
    try {
      FileWriter ingredientFile = new FileWriter("./files/ingredients.json");
      ingredientFile.write(ingredientList.toString());
      ingredientFile.close();
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }
}
