package assignment_4_recipe_app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for RecipeHandleConsole.
 */
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
      promptRemoveIngredient();
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

  /**
   * Prompts user for details to create a new ingredient.
   */
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
   * Prompts user for name to remove an ingredient.
   */
  public static void promptRemoveIngredient() {
    System.out.println("Name of ingredient to remove:");
    optScanner.nextLine();
    RecipeApp.ingredients.removeIngredientByName(optScanner.nextLine());
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
      promptNewRecipe();
      showRecipeOptions();
      break;
    case 'c':
      promptRemoveRecipe();
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

  /**
   * Prompts user for details to create a recipe.
   */
  public static void promptNewRecipe() {
    System.out.println("Name of the new recipe:");
    optScanner.nextLine();
    Recipe newRecipe = new Recipe();
    newRecipe.setName(optScanner.nextLine());
    System.out.println("Number of portions:");
    newRecipe.setNumberOfPortions(optScanner.nextInt());
    showIngredients();
    System.out.println("Add an ingredient (name has to be exact) (empty if next step):");
    optScanner.nextLine();
    String ingredientName = optScanner.nextLine();
    while (ingredientName.length() != 0) {
      Ingredient ingredientToAdd = RecipeApp.ingredients.getIngredientByName(ingredientName);
      if (ingredientToAdd != null) {
        newRecipe.addIngredient(ingredientToAdd);
        System.out.println("Add an ingredient (name has to be exact) (empty if next step):");
        ingredientName = optScanner.nextLine();
      } else {
        System.out.println("Ingredient cannot be found!");
        System.out.println("Add an ingredient (name has to be exact) (empty if next step):");
        ingredientName = optScanner.nextLine();
      }
    }
    ArrayList<Ingredient> ingredients = newRecipe.getIngredients();
    for (int i = 0; i < ingredients.size(); i++) {
      System.out
          .println("Please set amount of " + ingredients.get(i).getUnit() + " for " + ingredients.get(i).getName());
      newRecipe.setIngredientAmounts(ingredients.get(i).getName(), optScanner.nextInt());
    }

    System.out.println("Add an instruction (empty if next step):");
    optScanner.nextLine();
    String newInstruction = optScanner.nextLine();
    while (newInstruction.length() != 0) {
      newRecipe.addInstruction(newInstruction);
      System.out.println("Add an instruction (empty if next step):");
      newInstruction = optScanner.nextLine();
    }

    System.out.println("Add a comment (empty if next step):");
    String newComment = optScanner.nextLine();
    while (newComment.length() != 0) {
      newRecipe.addComment(newComment);
      System.out.println("Add a comment (empty if next step):");
      newComment = optScanner.nextLine();
    }
    RecipeApp.recipes.addRecipe(newRecipe);
  }

  /**
   * Prompts user for name to remove an ingredient.
   */
  public static void promptRemoveRecipe() {
    System.out.println("Name of recipe to remove:");
    optScanner.nextLine();
    RecipeApp.recipes.removeRecipeByName(optScanner.nextLine());
  }
}
