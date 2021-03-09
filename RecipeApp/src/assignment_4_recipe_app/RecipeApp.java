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
}
