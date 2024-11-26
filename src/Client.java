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
            while(fileReader.hasNext()) {
                String temp = fileReader.nextLine();
                String[] e = temp.split(",");
                Employee employee = new Employee(Integer.parseInt(e[0]), e[1], e[2], Integer.parseInt(e[3]));
                employees.add(employee);
            } // close while loop
            fileReader.close();
            EmployeeOperations operations = new EmployeeOperations();
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }//close try catch
    }//close main method
}//close Client class
