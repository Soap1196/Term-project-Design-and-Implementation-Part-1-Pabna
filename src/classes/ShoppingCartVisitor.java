package classes;


public interface ShoppingCartVisitor{
    double visit(composite composite, boolean isComp);
    double visit(leaf leaf, boolean isComp);
}

