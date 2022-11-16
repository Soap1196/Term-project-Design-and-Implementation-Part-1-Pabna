package classes;

public interface CurrentMarketVisitor {
    double visit(composite composite);
    double visit(leaf leaf);
}
