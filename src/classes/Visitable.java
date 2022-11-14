package classes;

public interface Visitable{
    int visit(composite composite);
    int visit(leaf leaf);
}

interface ItemElement
{
    public double accept(Visitable visitor, boolean isComp); 
}