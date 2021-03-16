package assignment_4_recipe_app;

import java.util.*;

public class Recipe {
  String name;
  int numberOfPortions;
  ArrayList<String> commentList = new ArrayList<String>();
  ArrayList<String> instructionList = new ArrayList<String>();
  ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

  public Recipe(String name) {
    this.name = name;
  }

  public void setNumberOfPortions(int newOfPortions) {
    this.numberOfPortions = newOfPortions;
  }

  public void addComment(String comment) {
    commentList.add(comment);
  }

  public void addInstruction(String instruction) {
    instructionList.add(instruction);
  }

  public void addIngredient(Ingredient newIngredient) {
    ingredientList.add(newIngredient);
  }

  public String getName() {
    return name;
  }

  public int getNumberOfPortions() {
    return numberOfPortions;
  }

  public ArrayList<String> getComments() {
    return commentList;
  }

  public ArrayList<String> getInstructions() {
    return instructionList;
  }

  public ArrayList<Ingredient> getIngredients() {
    return ingredientList;
  }
}
