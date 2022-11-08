package classes;

public class leaf implements items,MValueVisitable{
    public static leaf leaf;
    public String name;
    public double price;
    //New Market-Value Variable 
    public double market_value;//unqiue to items
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
    //Getter for new market-value variable
    public double getMarketValue()
    {
        return market_value;
    }
    //Setter for new market-value variable
    public void setMarketValue(double newMarketValue)
    {
        this.market_value = newMarketValue;
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
        System.out.println(name + " " + price + " " +  market_value + " " + xCoordinate + " " + yCoordinate + " " + length + " " + width + " " + height);
    }

    //Visitable Function (accept)
    @Override 
    public double accept(MValueVisitor visitor)
    {
        return visitor.visit(this);
    }
}
