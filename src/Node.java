public class Node {
    private Node left;
    private Node right;
    private Employee value;

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

    public void setLeft(Node node) {
        left = node;
    }

    public void setRight(Node node) {
        right = node;
    }

    public void setValue(Employee node) {
        value = node;
    }
}
