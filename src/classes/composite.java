package classes;

import java.util.ArrayList;
import java.util.List;

interface items{
    public void showItemDetails();
}

public class composite implements items{
    public static composite composite; 

    private List<items> itemslist = new ArrayList<items>();

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
    public double xCoordinate;
    public double yCoordinate;
    public double length;
    public double width;
    public double height;


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

}
