package classes;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{
    @Override
    public double visit(composite composite, boolean isComp)
    {      
        return composite.getCompPrice();
    }


    @Override
    public double visit(leaf leaf, boolean isComp)
    {
        return leaf.getPrice();
    }
}

