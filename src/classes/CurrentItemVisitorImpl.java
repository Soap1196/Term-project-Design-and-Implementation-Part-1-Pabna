package classes;

public class CurrentItemVisitorImpl implements CurrentItemVisitor{
    
        @Override
        public double visit(composite composite) {
            double price = composite.getCompPrice();
            return price;
        }
    
        @Override
        public double visit(leaf leaf) {
            double price = leaf.getPrice();
            return price;
        }
    
    
}
