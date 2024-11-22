public class Node {
    private final Node left;
    private final Node right;
    private final Employee value;

    public Node (Node left, Node right, Employee value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Employee getValue() {
        return value;
    }

}
