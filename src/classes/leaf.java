package classes;

import java.io.Serializable;

public class leaf implements items, Serializable{
    public static leaf leaf;
    public String name;
    public double price;
    public double MarketValue;
    public double xCoordinate;
    public double yCoordinate;
    public double length;
    public double width;
    public double height;

    

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double newPrice)
    {
        this.price = newPrice;
    }

    public double getMarketValue()
    {
        return MarketValue;
    }

    public void setMarketValue(double newMarketValue)
    {
        this.MarketValue = newMarketValue;
    }

    public double getXCoordinate()
    {
        return xCoordinate;
    }

    public void setXCoordinate(double newXCoordinate)
    {
        this.xCoordinate = newXCoordinate;
    }

    public double getYCoordinate()
    {
        return yCoordinate;
    }

    public void setYCoordinate(double newYCoordinate)
    {
        this.yCoordinate = newYCoordinate;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double newLength)
    {
        this.length = newLength;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double newWidth)
    {
        this.width = newWidth;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double newHeight)
    {
        this.height = newHeight;
    }

    @Override
    public void showItemDetails()
    {
        System.out.println(name + " " + price + " " + xCoordinate + " " + yCoordinate + " " + length + " " + width + " " + height);
    }

    @Override
    public double accept(CurrentItemVisitor visitor) {
        // TODO Auto-generated method stub
        return visitor.visit(this);
    }
}
