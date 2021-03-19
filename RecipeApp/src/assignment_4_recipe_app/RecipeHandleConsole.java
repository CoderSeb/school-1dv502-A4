package assignment_4_recipe_app;

import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecipeHandleConsole {
  static Scanner optScanner = new Scanner(System.in);

  /**
   * Prints a welcome message.
   */
  public static void sayWelcome() {
    System.out.println("\nHello and welcome to the no. 1 Recipe app!\nSuper high tech in a low tech environment.");
  }

  /**
   * Prints main menu and calls method to handle user input.
   */
  public static void showMainOptions() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("(1) - Ingredients.");
    System.out.println("(2) - Recipes.");
    System.out.println("(0) - Exit application.");
    handleMainOptions(optScanner.nextInt());
  }

  /**
   * Calls correct method depending on user input.
   * 
   * @param option as the user input.
   */
  public static void handleMainOptions(int option) {
    switch (option) {
    case 1:
      showIngredientOptions();
      break;
    case 2:
      showRecipeOptions();
      break;
    default:
      System.out.println("About to exit");
      RecipeApp.closeApp();
    }
  }

  /**
   * Displays ingredient menu and calls method to handle user input.
   */
  public static void showIngredientOptions() {
    System.out.println("\nIngredient menu");
    System.out.println("(a) - Show all ingredients.");
    System.out.println("(b) - Add an ingredients.");
    System.out.println("(c) - Remove an ingredient.");
    System.out.println("(x) - Back to main menu.");
    handleIngredientOptions(optScanner.next().charAt(0));
  }

  /**
   * Calls correct method depending on user input.
   * 
   * @param option as the user input.
   */
  public static void handleIngredientOptions(char option) {
    switch (option) {
    case 'a':
      showIngredients();
      showIngredientOptions();
      break;
    case 'b':
      promptNewIngredient();
      showIngredientOptions();
      break;
    case 'c':
      showIngredientOptions();
      break;
    default:
      showMainOptions();
      break;
    }
  }

  /**
   * Displays all ingredients.
   */
  public static void showIngredients() {
    System.out.println("\nIngredients\n" + "---------------");
    RecipeApp.ingredients.getAllIngredients().forEach(ingredient -> ingredient.parseToString());
  }

  public static void promptNewIngredient() {
    System.out.println("Name of new ingredient:");
    optScanner.nextLine();
    Ingredient newIngredient = new Ingredient();
    newIngredient.setName(optScanner.nextLine());
    System.out.println("Unit of measure:");
    newIngredient.setUnit(optScanner.nextLine());
    System.out.println("Price:");
    newIngredient.setPrice(optScanner.nextDouble());
    RecipeApp.ingredients.addIngredient(newIngredient);
    System.out.println("Successfully added ingredient");
    newIngredient.parseToString();
  }

  /**
   * Displays recipe menu and calls method to handle input.
   */
  public static void showRecipeOptions() {
    System.out.println("\nRecipe menu");
    System.out.println("(a) - Show all recipes.");
    System.out.println("(b) - Add a recipe.");
    System.out.println("(c) - Remove a recipe.");
    System.out.println("(d) - Edit a recipe.");
    System.out.println("(x) - Back to main menu.");
    handleRecipeOptions(optScanner.next().charAt(0));
  }

  /**
   * Calls the correct method depending on user input.
   * 
   * @param option as the user input.
   */
  public static void handleRecipeOptions(char option) {
    switch (option) {
    case 'a':
      showRecipes();
      showRecipeOptions();
      break;
    case 'b':
      showRecipeOptions();
      break;
    case 'c':
      showRecipeOptions();
      break;
    case 'd':
      showRecipeOptions();
      break;
    default:
      showMainOptions();
      break;
    }
  }

  /**
   * Displays all recipes.
   */
  public static void showRecipes() {
    System.out.println("\nRecipes\n" + "---------------");
    RecipeApp.recipes.getAllRecipes().forEach(recipe -> recipe.parseToString());
  }

}
