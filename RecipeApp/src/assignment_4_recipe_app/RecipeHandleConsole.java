package assignment_4_recipe_app;

import java.util.Scanner;
import org.json.JSONArray;

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
      createIngredient();
      showIngredientOptions();
      break;
    case 'c':
      System.out.println("Type ingredient name to remove: ");
      optScanner.nextLine();
      RecipeHandleFile.removeIngredient(optScanner.nextLine());
      showIngredientOptions();
      break;
    default:
      showMainOptions();
      break;
    }
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
      createRecipe();
      showRecipeOptions();
      break;
    case 'c':
      System.out.println("Type recipe name to remove: ");
      optScanner.nextLine();
      RecipeHandleFile.removeRecipe(optScanner.nextLine());
      showRecipeOptions();
      break;
    case 'd':
      handleRecipeModification();
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
    JSONArray recipes = RecipeHandleFile.readRecipes();
    for (int i = 0; i < recipes.length(); i++) {
      System.out
          .println(recipes.getJSONObject(i).get("name") + ", Portions: " + recipes.getJSONObject(i).get("portions"));
    }
  }

  public static void handleRecipeModification() {
    System.out.println("Type recipe name to modify: ");
    optScanner.nextLine();
    String recipeName = optScanner.nextLine();
    System.out.println("Type number of portions: ");
    Recipe modifiedRecipe = new Recipe(recipeName, optScanner.nextInt());

    System.out.println("Add a comment (empty if next step): ");
    optScanner.nextLine();
    String newComment = optScanner.nextLine();
    while (newComment.length() > 0) {
      modifiedRecipe.addComment(newComment);
      System.out.println("Add a comment (empty if next step): ");
      newComment = optScanner.nextLine();
    }

    System.out.println("Add an instruction (empty if next step): ");
    String newInstruction = optScanner.nextLine();
    while (newInstruction.length() > 0) {
      modifiedRecipe.addInstruction(newInstruction);
      System.out.println("Add an instruction (empty if next step): ");
      newInstruction = optScanner.nextLine();
    }

    showIngredients();
    System.out.println();
    RecipeHandleFile.modifyRecipe(modifiedRecipe);
  }

  /**
   * Creates a recipe from user inputs.
   */
  public static void createRecipe() {
    System.out.println("Type a new recipe name: \n");
    optScanner.nextLine();
    String newRecipeName = optScanner.nextLine();
    System.out.print("Number of portions: ");
    int newPortions = optScanner.nextInt();
    Recipe newRecipe = new Recipe(newRecipeName, newPortions);
    RecipeHandleFile.writeToRecipe(newRecipe);
  }

  /**
   * Displays all ingredients.
   */
  public static void showIngredients() {
    System.out.println("\nIngredients\n" + "---------------");
    JSONArray ingredients = RecipeHandleFile.readIngredients();
    for (int i = 0; i < ingredients.length(); i++) {
      Object name = ingredients.getJSONObject(i).get("name");
      Object unit = ingredients.getJSONObject(i).get("unit");
      Object price = ingredients.getJSONObject(i).get("price");
      System.out.println(name + ":" + unit + ":" + price);
    }
  }

  /**
   * Creates an ingredient from user inputs.
   */
  public static void createIngredient() {
    System.out.println("Ingredient name: ");
    optScanner.nextLine();
    String ingredientName = optScanner.nextLine();
    System.out.println("Unit of measure: ");
    String unit = optScanner.nextLine();
    System.out.println("Price: ");
    double price = optScanner.nextDouble();
    System.out.println("New ingredient is: " + ingredientName + ":" + unit + ":" + price);
    Ingredient newIngredient = new Ingredient(ingredientName, unit, price);
    RecipeHandleFile.writeIngredient(newIngredient);
  }
}
