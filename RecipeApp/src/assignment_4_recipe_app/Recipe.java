package assignment_4_recipe_app;

import java.util.*;

public class Recipe {
  String name;
  int portions;
  ArrayList<String> commentList = new ArrayList<String>();
  ArrayList<String> instructionList = new ArrayList<String>();
  ArrayList<String> ingredientList = new ArrayList<String>();

  public Recipe(String name, int portions) {
    this.name = name;
    this.portions = portions;
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

  public void addIngredient(String newIngredient) {
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

  public ArrayList<String> getIngredients() {
    return ingredientList;
  }

  public void parseToString() {
    System.out.println("\n" + this.name);
    System.out.println("Portions: " + this.portions);
    System.out.println("Ingredients for " + this.name);
    ingredientList.forEach(ingredient -> System.out.println(ingredient));
    System.out.println("Instructions for " + this.name);
    instructionList.forEach(instruction -> System.out.println(instruction));
    System.out.println("Comments for " + this.name);
    commentList.forEach(comment -> System.out.println(comment));
  }
}
