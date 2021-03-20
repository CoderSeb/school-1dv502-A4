package assignment_4_recipe_app;

public class Ingredient {
  private String name;
  private String unitOfMeasure;
  private double price;

  public void setName(String name) {
    this.name = name;
  }

  public void setUnit(String unit) {
    this.unitOfMeasure = unit;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getUnit() {
    return unitOfMeasure;
  }

  public Double getPrice() {
    return price;
  }

  public void parseToString() {
    System.out.println(this.name + ":" + this.unitOfMeasure + ":" + this.price);
  }
}
