# Basic Binary Search Tree Operations

### Project Description

You are given a list of 10k employees ordered by `ID` from a company in a file. The employee information will be given in csv files for each company. The information is extracted from their databases, and it has the following attributes for the employee: **_id_**, **_first_name_**, **_last_name_**, **_age_**.

The company wants to use a data structure to represent the employees that supports the following operations:
1. Get an employee's information in `O(logn)` time complexity.
2. Remove an employee in `O(logn)` time complexity.
3. Add a new employee in `O(logn)` time complexity.

### Project Requirement

1. You are required to construct a **`balanced`** **binary search tree** to represent the employess.

For a node in the BST, there will be `3` fields: **_left_**, **_right_** and **_value_.** The definition is as follows:

```java
Class Node {
    private Node left;
    private Node right;
    private Employee value;
}
```

_Note: This is just a definition of the node class, you will need to implement the constructor, getter methods, setter methods, etc._

The **_left_** and **_right_** fields point to the node's left and right children, and **_value_** field holds a value of `Employee` type.

2. There is an employee, whose age is over `65`, and s/he is retireing. You will need to remove the node representing this employee from the `BST`. Because you are no longer allowed to read the file after you constructing the `BST`, you can only traverse the `BST` and find this employee, then remove the node.
3. After removing this node, you must make sure the `BST` still maintains all properties of a `binary search tree`, i.e. for a given node, the value of its left child is less than this node's value, and the value of its right child is larger than or equal to this node's value.
4. After a few days, the company hires a new employee, whose first name is `London`, last name is `Hodge` and age is `27`. The `ID` is naturally incremented by `1` from the current largest employee ID. You are required to add this employee to the `BST`, and `BST` maintains all its properties.
5. Submit your source code files.
6. Write a report on which part is simple, which part is difficult and what you have learned from implementing these operations.

### Extra Credit

1. Can we use other linear data structures, such as `array` and `linked list` to achieve the requirements? Why or why not?
2. What if the `BST` we constructed is not a **`balanced`** one? What will be differences?
3. Write your thoughts on the above questions in the report.
