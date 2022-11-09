package classes;


public interface ShoppingCartVisitor{
    double visit(composite composite);
    double visit(leaf leaf);
}

