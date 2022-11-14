package classes;

public interface items{

    public double accept(ShoppingCartVisitor visitor, boolean isComp);

    public Boolean isComp();

    public void showItemDetails();

    public double calculatePurchasePrice();

    public double calculateMarketValue();
}