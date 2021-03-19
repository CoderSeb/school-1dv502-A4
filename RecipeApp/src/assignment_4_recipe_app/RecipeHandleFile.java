package assignment_4_recipe_app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import org.json.*;

/**
 * Class for RecipeHandleFile.
 */
public class RecipeHandleFile {
  private static File recipeFile = new File("./files/recipes.json");
  private static File ingredientFile = new File("./files/ingredients.json");

  /**
   * Looks for the .json files, if not found they will be created.
   */
  public static void checkFiles() {
    try {
      if (recipeFile.exists()) {
        System.out.println("Found a recipe file!");
      } else {
        System.out.println("A recipe file does not exist...\nCreating one...");
        recipeFile.getParentFile().mkdirs();
        if (recipeFile.createNewFile()) {
          System.out.println("File created: " + recipeFile.getName());
          updateRecipes(new JSONArray());
        }
      }
      if (ingredientFile.exists()) {
        System.out.println("Found an ingredient file!");
      } else {
        System.out.println("An ingredient file does not exist...\nCreating one...");
        ingredientFile.getParentFile().mkdirs();
        if (ingredientFile.createNewFile()) {
          System.out.println("File created: " + ingredientFile.getName());
          updateIngredients(new JSONArray());
        }
      }
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }

  /**
   * Writes a new recipe to json.
   * 
   * @param newRecipe as the new recipe.
   */
  private static void writeToRecipe(Recipe newRecipe) {
    JSONObject recipeDetails = new JSONObject();
    recipeDetails.put("name", newRecipe.name);
    recipeDetails.put("portions", newRecipe.portions);
    JSONArray ingredientList = new JSONArray(newRecipe.ingredientList);
    JSONArray instructionList = new JSONArray(newRecipe.instructionList);
    JSONArray commentList = new JSONArray(newRecipe.commentList);
    recipeDetails.put("ingredients", ingredientList);
    recipeDetails.put("instructions", instructionList);
    recipeDetails.put("comments", commentList);
    JSONArray recipeList = readRecipes();
    recipeList.put(recipeDetails);
    updateRecipes(recipeList);
  }

  /**
   * Updates the recipes.json with the given JSONArray.
   * 
   * @param recipeList as the JSONArray.
   */
  private static void updateRecipes(JSONArray recipeList) {
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
   * Removes a recipe given the name.
   * 
   * @param recipeName as the recipe name.
   */
  public static void removeRecipe(String recipeName) {
    JSONArray recipes = readRecipes();
    for (int i = 0; i < recipes.length(); i++) {
      if (recipes.getJSONObject(i).get("name").toString().equals(recipeName)) {
        recipes.remove(i);
      }
    }
    updateRecipes(recipes);
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

  /**
   * Updates the ingredient.json with the given JSONArray.
   * 
   * @param ingredientList as the JSONArray.
   */
  private static void updateIngredients(JSONArray ingredientList) {
    try {
      FileWriter ingredientFile = new FileWriter("./files/ingredients.json");
      ingredientFile.write(ingredientList.toString());
      ingredientFile.close();
    } catch (IOException e) {
      System.out.println("An error occurred!");
      e.printStackTrace();
    }
  }

  /**
   * Writes an ingredient to Json.
   * 
   * @param newIngredient as the Ingredient.a
   */
  private static void writeIngredient(Ingredient newIngredient) {
    JSONObject ingredientJson = new JSONObject();
    ingredientJson.put("name", newIngredient.getName());
    ingredientJson.put("unit", newIngredient.getUnit());
    ingredientJson.put("price", newIngredient.getPrice());
    JSONArray ingredientList = readIngredients();
    ingredientList.put(ingredientJson);
    updateIngredients(ingredientList);
  }

  /**
   * Saves RecipeBook to json.
   * 
   * @param listToAdd as the RecipeBook to save.
   */
  private static void saveRecipes(RecipeBook listToAdd) {
    updateRecipes(new JSONArray());
    listToAdd.getAllRecipes().forEach(recipe -> writeToRecipe(recipe));
  }

  /**
   * Saves IngredientStore to json.
   * 
   * @param listToAdd as the IngredientStore to save.
   */
  private static void saveIngredients(IngredientStore listToAdd) {
    listToAdd.getAllIngredients().forEach(ingredient -> {
      writeIngredient(ingredient);
    });
  }

  /**
   * Calls the appropriate methods to save the current IngredientStore and
   * RecipeBook to Json.
   */
  public static void saveToJson() {
    updateIngredients(new JSONArray());
    saveIngredients(RecipeApp.ingredients);
    saveRecipes(RecipeApp.recipes);
  }
}
