package classes;

public class CurrentMarketVisitorImpl implements CurrentMarketVisitor{
        @Override
        public double visit(composite composite) {
            double price = composite.getMarketValue();
            return price;
        }
    
        @Override
        public double visit(leaf leaf) {
            double price = leaf.getMarketValue();
            return price;
        }
}
