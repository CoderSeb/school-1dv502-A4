package assignment_4_recipe_app;

import java.util.*;

public class Recipe {
  String name;
  int portions;
  ArrayList<String> commentList = new ArrayList<String>();
  ArrayList<String> instructionList = new ArrayList<String>();
  ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

  public void setName(String name) {
    this.name = name;
  }

  public void setNumberOfPortions(int newPortions) {
    this.portions = newPortions;
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
    return portions;
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

  public void parseToString() {
    System.out.println("\n" + this.name);
    System.out.println("Portions: " + this.portions);
    System.out.println("-Ingredients for " + this.name + "-");
    ingredientList.forEach(ingredient -> ingredient.parseToString());
    System.out.println("-Instructions for " + this.name + "-");
    instructionList.forEach(instruction -> System.out.println(instruction));
    System.out.println("-Comments for " + this.name + "-");
    commentList.forEach(comment -> System.out.println(comment));
  }
}
