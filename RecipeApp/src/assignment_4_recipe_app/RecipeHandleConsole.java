package assignment_4_recipe_app;

import java.util.Scanner;

import org.json.JSONArray;

public class RecipeHandleConsole {
  static Scanner optScanner = new Scanner(System.in);

  public static void sayWelcome() {
    System.out.println("\nHello and welcome to the no. 1 Recipe app!\nSuper high tech in a low tech environment.");
  }

  public static void showMainOptions() {
    System.out.println("\nWhat would you like to do?");
    System.out.println("(1) - Ingredients.");
    System.out.println("(2) - Recipes.");
    System.out.println("(0) - Exit application.");
    handleMainOptions(optScanner.nextInt());
  }

  public static void handleMainOptions(int option) {
    System.out.println(option);
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

  public static void showIngredientOptions() {
    System.out.println("\nIngredient menu");
    System.out.println("(a) - Show all ingredients.");
    System.out.println("(b) - Add an ingredients.");
    System.out.println("(c) - Remove an ingredient.");
    System.out.println("(x) - Back to main menu.");
    handleIngredientOptions(optScanner.next().charAt(0));
  }

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
      // TODO: Functionality to remove aan ingredient.
      System.out.println("Remove Ingredient....");
      showIngredientOptions();
    default:
      showMainOptions();
      break;
    }
  }

  public static void showRecipeOptions() {
    System.out.println("\nRecipe menu");
    System.out.println("(a) - Show all recipes.");
    System.out.println("(b) - Add a recipe.");
    System.out.println("(c) - Remove a recipe.");
    System.out.println("(x) - Back to main menu.");
    handleRecipeOptions(optScanner.next().charAt(0));
  }

  public static void handleRecipeOptions(char option) {
    switch (option) {
    case 'a':
      showRecipes();
      showRecipeOptions();
      break;
    case 'b':
      System.out.println("Type a new recipe name: \n");
      optScanner.nextLine();
      String newRecipeName = optScanner.nextLine();
      RecipeHandleFile.writeToRecipe(newRecipeName);
      showRecipeOptions();
      break;
    case 'c':
      // TODO: Functionality to remove a recipe.
      System.out.println("Remove recipe....");
      showRecipeOptions();
    default:
      showMainOptions();
      break;
    }
  }

  public static void showRecipes() {
    System.out.println("\nRecipes\n" + "---------------");
    JSONArray recipes = RecipeHandleFile.readRecipes();
    for (int i = 0; i < recipes.length(); i++) {
      System.out.println(recipes.getJSONObject(i).get("name"));
    }
  }

  public static void showIngredients() {
    System.out.println("\nIngredients\n" + "---------------");
    JSONArray ingredients = RecipeHandleFile.readIngredients();
    for (int i = 0; i < ingredients.length(); i++) {
      System.out.println(ingredients.getJSONObject(i).get("name"));
    }
  }

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
