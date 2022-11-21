package classes;

import javafx.scene.shape.Rectangle;

public class Srectangle extends Rectangle{
    private String name;
    private double price;
    private double marketValue;
    private boolean isComposite;
    private composite composite;
    private leaf leaf;

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
    }

    // Getter
  public double getPrice() {
    return price;
  }

  // Setter
  public void setPrice(double newPrice) {
    this.price = newPrice;

    }

    // Getter
  public double getMarketValue() {
    return marketValue;
  }

  // Setter
  public void setMarketValue(double newMarketValue) {
    this.marketValue = newMarketValue;

    }
  

// Getter
public boolean getisComposite() {
    return isComposite;
  }

  // Setter
  public void setisComposite(boolean newisComposite) {
    this.isComposite = newisComposite;

    }
// Getter
public composite getComposite() {
    return composite;
  }

  // Setter
  public void setComposite(composite newComposite) {
    this.composite = newComposite;

    }

    // Getter
public leaf getLeaf() {
    return leaf;
  }

  // Setter
  public void setLeaf(leaf newleaf) {
    this.leaf = newleaf;

    }

}

