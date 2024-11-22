public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Employee(int id, String first, String last, int age) {
        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nFirst Name: %s\nLast name: %s\nAge: %d\n", id, firstName, lastName, age);
    }
}
