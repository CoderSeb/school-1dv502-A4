package assignment_4_recipe_app;

/**
 * Main class for the recipe application.
 */
public class RecipeApp {
  static IngredientStore ingredients = new IngredientStore();
  static RecipeBook recipes = new RecipeBook();

  public static void main(String[] args) {
    startApp();
  }

  /**
   * To run when the app starts.
   */
  static void startApp() {
    RecipeHandleConsole.sayWelcome();
    RecipeHandleFile.checkFiles();
    ingredients.getSavedIngredients();
    recipes.getSavedRecipes();
    RecipeHandleConsole.showMainOptions();
  }

  static void closeApp() {
    RecipeHandleFile.saveToJson();
  }
}
