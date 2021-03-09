package assignment_4_recipe_app;

import java.util.*;

public class Recipe {
  String name;
  int numberOfPortions;
  ArrayList<String> commentList;
  ArrayList<String> instructionList;

  public Recipe(String name) {
    this.name = name;
  }

  public void setNumberOfPortions(int newOfPortions) {
    numberOfPortions = newOfPortions;
  }

  public void addComment(String comment) {
    commentList.add(comment);
  }

  public void addInstruction(String instruction) {
    instructionList.add(instruction);
  }
}
