package classes;

interface ShoppingCartVisitor{
    int visit(composite composite);
    int visit(leaf leaf);
}

interface ItemElement
{
    public int accept(ShoppingCartVisitor visitor); 
}