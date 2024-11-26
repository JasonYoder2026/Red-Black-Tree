import java.util.List;

public class EmployeeOperations {
    private Node constructHelper(List<Employee> employees, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;//base case
        }
        if (startIndex == endIndex) {
            return new Node (null, null, employees.getFirst());
        }

        int middleIndex = startIndex + (endIndex-startIndex) / 2;

        Node root = new Node(null, null, employees.get(middleIndex));

        root.setLeft(constructHelper(employees, startIndex, middleIndex-1));
        root.setRight(constructHelper(employees, middleIndex+1, endIndex));

        return root;
    }

    public Node constructBalancedEmployeeBST(List<Employee> employeeList) {
        return constructHelper(employeeList, 0, employeeList.size()-1);
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
            Node minimum = this.getMinimum(root.getRight());
            root.setValue(minimum.getValue());
            root.setRight(removeRetire(root.getRight(), minimum.getValue()));
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
        if (root.getRight() == null) {
            root.setRight(new Node(null, null, e));
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
}
