package classes;

public interface items{
    public void showItemDetails();
    public double accept(CurrentItemVisitor visitor);
}