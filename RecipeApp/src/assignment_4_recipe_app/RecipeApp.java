package assignment_4_recipe_app;

import java.util.*;

/**
 * Main class for the recipe application.
 */
public class RecipeApp {
  static RecipeHandleConsole consoleStuff = new RecipeHandleConsole();

  public static void main(String[] args) {
    startApp();
  }

  /**
   * To run when the app starts.
   */
  static void startApp() {
    consoleStuff.sayWelcome();
    RecipeHandleFile.checkFiles();
    consoleStuff.showOptions();
  }

  public static void handleOptions(int option) {
    System.out.println(option);
    switch (option) {
      case 1:
        System.out.println("Create a new ingredient");
        break;
      case 2:
        System.out.println("Create a new recipe");
        break;
      default:
        System.out.println("About to exit");
    }
  }
}
