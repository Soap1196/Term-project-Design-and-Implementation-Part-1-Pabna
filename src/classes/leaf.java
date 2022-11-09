package classes;

public class leaf implements items{
    public static leaf leaf;
    public String name;
    public double price;
    public double xCoordinate;
    public double yCoordinate;
    public double length;
    public double width;
    public double height;
    public double marketValue;

    

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

    public double getMarketValue()
    {
        return marketValue;
    }

    public void setMarketValue(double newMarketValue)
    {
        this.marketValue = newMarketValue;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public void showItemDetails()
    {
        System.out.println(name + " " + price + " " + xCoordinate + " " + yCoordinate + " " + length + " " + width + " " + height);
    }

    @Override
    public double calculatePurchasePrice()
    {
        double PurchasePrice = price;
        return PurchasePrice;
    }

    @Override
    public double calculateMarketValue()
    {
        double PurchasePrice = price;
        return PurchasePrice;
    }
}
