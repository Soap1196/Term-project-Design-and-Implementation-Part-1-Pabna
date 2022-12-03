package classes;

import java.io.Serializable;
import java.util.ArrayList;



public class composite implements items, Serializable{
    public static composite composite; 

    private ArrayList<items> itemslist = new ArrayList<items>();

    @Override
    public void showItemDetails()
    {
        System.out.println(name + " " + price + " " + xCoordinate + " " + yCoordinate + " " + length + " " + width + " " + height);
        System.out.println("{");
        for(items x:itemslist)
        {
            x.showItemDetails();
        }
        System.out.println("}");
    }

    public ArrayList<items> getItems() {
        return (ArrayList<items>) itemslist;
    }

    public void setItems(ArrayList<items> items) {
        this.itemslist = items;
    }

    public void additem(items x)
    {
        itemslist.add(x);
    }

    public void removeitems(items x)
    {
        itemslist.remove(x);
    }
    
    public String name;
    public double price;
    public double MarketValue = 0.0;
    public double xCoordinate;
    public double yCoordinate;
    public double length;
    public double width;
    public double height;
    private composite parent;


    // Getters
    public String getCompName() {
        return name;
    }
    public double getCompPrice() {
        return price;
    }
    public double getCompXcoordinate() {
        return xCoordinate;
    }
    public double getCompYcoordinate() {
        return yCoordinate;
    }
    public double getCompLength() {
        return length;
    }
    public double getCompWidth() {
        return width;
    }
    public double getCompHeight() {
        return height;
    }
    public double getMarketValue() {
        return MarketValue;
    }
    public composite getCompParent() {
        return parent;
    }

    // Setters
    public void setCompName(String name) {
        this.name = name;
    }
    public void setCompPrice(double price) {
        this.price = price;
    }
    public void setCompXcoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setCompYcoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    public void setCompLength(double length) {
        this.length = length;
    }
    public void setCompWidth(double width) {
        this.width = width;
    }
    public void setCompHeight(double height) {
        this.height = height;
    }
    public void setMarketValue(double MarketValue) {
        this.MarketValue = MarketValue;
    }
    public void setCompParent(composite parent) {
        this.parent = parent;
    }

    @Override
    public double accept(CurrentItemVisitor visitor) {
        return visitor.visit(this);
    }

}
