package assignment_4_recipe_app;

import java.util.Scanner;

public class RecipeHandleConsole {
  Scanner optScanner = new Scanner(System.in);

  public void sayWelcome() {
    System.out.println("\nHello and welcome to the no. 1 Recipe app!\nSuper high tech in a low tech environment.");
  }

  public void showOptions() {
    System.out.println("What would you like to do?");
    System.out.println("(1) - Add ingredient.");
    System.out.println("(2) - Add recipe.");
    System.out.println("(0) - Exit application.");
    RecipeApp.handleOptions(optScanner.nextInt());
  }
}
