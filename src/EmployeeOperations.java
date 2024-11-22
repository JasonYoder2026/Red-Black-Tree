import java.util.List;

public class EmployeeOperations {
    private Node constructHelper(List<Employee> employees, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;//base case
        }
        if (startIndex == endIndex) {
            return new Node (null, null, employees.getFirst());
        }

        Node root = new Node();

        return root;
    }//close constructHelper
}//close class
