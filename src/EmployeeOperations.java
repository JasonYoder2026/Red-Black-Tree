import java.util.*;

public class EmployeeOperations {
    private Node constructHelper(List<Employee> employees, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null; // Base case: no elements to process
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        Node root = new Node(null, null, employees.get(middleIndex));

        // Recursively construct left and right subtrees
        root.setLeft(constructHelper(employees, startIndex, middleIndex - 1));
        root.setRight(constructHelper(employees, middleIndex + 1, endIndex));

        return root;
    }

    public Node constructBalancedEmployeeBST(List<Employee> employeeList) {
        return constructHelper(employeeList, 0, employeeList.size() - 1);
    }

    public Node searchRetire(Node root) {
        if (root == null) {
            return null;
        }
        if (root.getValue().getAge() > 65) {
            return root;
        }

        Node retiredEmployeeNode = searchRetire(root.getLeft());
        if (retiredEmployeeNode != null) {
            return retiredEmployeeNode;
        }

        return searchRetire(root.getRight());
    }

    public Node removeRetire(Node root, Employee employee) {
        if (root == null) {
            return null;
        }
        if (employee.getId() < root.getValue().getId()) {
            root.setLeft(removeRetire(root.getLeft(), employee));
        } else if (employee.getId() > root.getValue().getId()) {
            root.setRight(removeRetire(root.getRight(), employee));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                Node minimum = this.getMinimum(root.getRight());
                root.setValue(minimum.getValue());
                root.setRight(removeRetire(root.getRight(), minimum.getValue()));
            }
        }

        return root;
    }

    private Node getMinimum(Node root) {
        if (root.getLeft() == null) {
            return root;
        }
        return getMinimum(root.getLeft());
    }

    public void insertNewHire(Node root, Employee e) {
        if (e.getId() < root.getValue().getId()) {
            // Insert in the left subtree
            if (root.getLeft() == null) {
                root.setLeft(new Node(null, null, e));
            } else {
                insertNewHire(root.getLeft(), e);
            }
        } else {
            // Insert in the right subtree
            if (root.getRight() == null) {
                root.setRight(new Node(null, null, e));
            } else {
                insertNewHire(root.getRight(), e);
            }
        }
    }

    public Node search(Node root, int id) {
        if (root == null) {
            return null;
        }
        if (root.getValue().getId() == id) {
            return root;
        }
        if (id < root.getValue().getId()) {
            return search(root.getLeft(), id);
        }
        return search(root.getRight(), id);
    }

    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.getLeft());
        System.out.println(root.getValue().toString());
        inorderTraversal(root.getRight());
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        int level = 0;
        while (!dq.isEmpty()) {
            int size  = dq.size();
            System.out.println("----------------New Level-------------");
            System.out.println("Level: " + level + " has " + size);
            while (size-- > 0) {
                Node current = dq.pollFirst();
                System.out.println(current.getValue().toString());
                Node left = current.getLeft();
                Node right = current.getRight();
                if (left != null) {
                    dq.add(left);
                }
                if (right != null) {
                    dq.add(right);
                }
            }//close inner while
            ++level;
        }//close outer while
    }//close levelOrder
}
