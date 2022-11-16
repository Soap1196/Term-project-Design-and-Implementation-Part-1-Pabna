package classes;

public interface CurrentItemVisitor {
    double visit(composite composite);
    double visit(leaf leaf);
}
