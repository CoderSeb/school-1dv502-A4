package assignment_4_recipe_app;

import java.io.File;
import java.io.IOException;

public class RecipeHandleFile {
  static File recipeFile = new File("./files/recipes.txt");
  static File ingredientFile = new File("./files/ingredients.txt");

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
}
