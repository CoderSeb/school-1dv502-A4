package assignment_4_recipe_app;

import java.util.*;

public class Recipe {
  String name;
  int portions;
  Double totalCost;
  ArrayList<String> ingredientAmounts = new ArrayList<String>();
  ArrayList<String> commentList = new ArrayList<String>();
  ArrayList<String> instructionList = new ArrayList<String>();
  ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

  public void setName(String name) {
    this.name = name;
  }

  public void setNumberOfPortions(int newPortions) {
    this.portions = newPortions;
  }

  public void setTotalCost(Double cost) {
    if (this.totalCost == null) {
      this.totalCost = 0.0;
    }
    this.totalCost += cost;
  }

  public void setIngredientAmounts(String ingredientName, int amount) {
    Ingredient ingredient = getIngredientByName(ingredientName);
    Double cost = ingredient.getPrice() * amount;
    setTotalCost(cost);
    addIngredientAmounts(ingredient.getName() + ":" + amount + ":" + ingredient.getUnit() + ":" + cost);
  }

  public void addIngredientAmounts(String newAmountString) {
    ingredientAmounts.add(newAmountString);
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

  public Double getCost() {
    return totalCost;
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

  public Ingredient getIngredientByName(String name) {
    for (int i = 0; i < ingredientList.size(); i++) {
      if (ingredientList.get(i).getName().equals(name)) {
        return ingredientList.get(i);
      }
    }
    return null;
  }

  public void parseToString() {
    System.out.println("\n" + this.name);
    System.out.println("Portions: " + this.portions);
    System.out.println("Total cost: " + this.getCost());
    System.out.println("-Ingredients for " + this.name + "-");
    ingredientList.forEach(ingredient -> ingredient.parseToString());
    System.out.println("-Ingredient amounts and cost-");
    ingredientAmounts.forEach(ingredientAmount -> System.out.println(ingredientAmount));
    System.out.println("-Instructions for " + this.name + "-");
    instructionList.forEach(instruction -> System.out.println("*" + instruction));
    System.out.println("-Comments for " + this.name + "-");
    commentList.forEach(comment -> System.out.println(comment));
  }
}
