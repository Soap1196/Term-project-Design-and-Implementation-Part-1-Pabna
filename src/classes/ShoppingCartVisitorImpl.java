package classes;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{
    @Override
    public double visit(composite composite)
    {
        return composite.getCompPrice();
    }


    @Override
    public double visit(leaf leaf)
    {
        return leaf.getPrice();
    }
}

