import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String inputFile = "company.csv";
        List<Employee> employees = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new File(inputFile));
            String header = fileReader.nextLine();
            while(fileReader.hasNextLine()) {
                String temp = fileReader.nextLine();
                String[] e = temp.split(",");
                Employee employee = new Employee(Integer.parseInt(e[0]), e[1], e[2], Integer.parseInt(e[3]));
                employees.add(employee);
            } // close while loop
            fileReader.close();


            EmployeeOperations operations = new EmployeeOperations();

            Node root = operations.constructBalancedEmployeeBST(employees);

            Node retiredEmployeeNode = operations.searchRetire(root);
            int retiredID = retiredEmployeeNode.getValue().getId();
            System.out.println("Retired employee: " + retiredEmployeeNode.getValue().toString());
            operations.removeRetire(root, retiredEmployeeNode.getValue());

            Node node = operations.search(root, retiredID);
            if (node == null) {
                System.out.println("Retired employee has been removed.");
            } else {
                System.out.println(node.getValue().toString());
            }

            Employee newHire = new Employee(100001, "London", "Hodge", 27);
            operations.insertNewHire(root, newHire);

            operations.levelOrderTraversal(root);
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }//close try catch
    }//close main method
}//close Client class
