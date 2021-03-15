package assignment_4_recipe_app;

/**
 * Main class for the recipe application.
 */
public class RecipeApp {

  public static void main(String[] args) {
    startApp();
  }

  /**
   * To run when the app starts.
   */
  static void startApp() {
    RecipeHandleConsole.sayWelcome();
    RecipeHandleFile.checkFiles();
    RecipeHandleConsole.showMainOptions();
  }
}
