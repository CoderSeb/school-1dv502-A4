package assignment_4_recipe_app;

import java.util.Scanner;

public class RecipeHandleConsole {
  static Scanner optScanner = new Scanner(System.in);

  public void sayWelcome() {
    System.out.println("\nHello and welcome to the no. 1 Recipe app!\nSuper high tech in a low tech environment.");
  }

  public static void showOptions() {
    System.out.println("What would you like to do?");
    System.out.println("(1) - Add ingredient.");
    System.out.println("(2) - Add recipe.");
    System.out.println("(0) - Exit application.");
    handleOptions(optScanner.nextInt());
  }

  public static void handleOptions(int option) {
    System.out.println(option);
    switch (option) {
    case 1:
      System.out.println("Create a new ingredient");
      createIngredient();
      showOptions();
      break;
    case 2:
      System.out.println("Type a new recipe name: \n");
      optScanner.nextLine();
      String newRecipeName = optScanner.nextLine();
      RecipeHandleFile.writeToRecipe(newRecipeName);
      showOptions();
      break;
    default:
      System.out.println("About to exit");
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
