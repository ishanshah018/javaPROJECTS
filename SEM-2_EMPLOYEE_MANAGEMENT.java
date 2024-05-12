// CAN BE UPDATED FURTHER CAN BE ADDED NEW FEATURES



/*
This Java code provides a simple yet functional Employee Management System (EMS). 
It allows users to efficiently manage employee data by adding new employee records, removing existing ones,
updating employee details, and viewing a comprehensive list of all employees within the system.*/
/*


Problem Statement: Employee Management System
Implement an employee management system in Java using ArrayList and a class. The system 
should have the following functionalities:
Add an employee to the system
Remove an employee from the system
Update an employee's details
Display all employees in the system
To implement this system, you can create an Employee class with attributes such as name, 
age, salary, etc. Then, you can create an ArrayList to store all the employees. You can then 
implement functions to add, remove, update and display employees.

*/

import java.util.*;

class Employee {
    String name;
    String age;
    String salary;

    public Employee(String name, String age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

}

class QB215 {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Employee> a1 = new ArrayList<>();

    void add() {
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Age: ");
        String age = sc.nextLine();

        System.out.println("Enter Salary: ");
        String salary = sc.nextLine();

        Employee emp = new Employee(name, age, salary);
        a1.add(emp);

    }

    void remove() {
        System.out.println("Enter Index you want to remove: ");
        int index = sc.nextInt();

        if (index >= 0 && index < a1.size()) {
            Employee e = a1.get(index);
            a1.remove(index);
            System.out.println("Employee removed is: " + e.getName());

        } else {
            System.out.println("INVALID CHOICE !!");
        }

    }

    void update() {
        System.out.println("Enter Index number to update");
        int index = sc.nextInt();

        if (index >= 0 && index < a1.size()) {
            Employee e = a1.get(index);
            sc.nextLine();
            System.out.println("Enter new name(if not than leave empty)");
            String newname = sc.nextLine();

            System.out.println("Enter new age(if not than leave empty)");
            String newage = sc.nextLine();

            System.out.println("Enter new Salary(if not than leave empty)");
            String newsalary = sc.nextLine();

            if (!newname.isEmpty()) {
                e.setName(newname);
            }
            if (!newage.isEmpty()) {
                e.setAge(newage);
            }
            if (!newsalary.isEmpty()) {
                e.setSalary(newsalary);
            }

            System.out.println("Employee Updated Succesfully !!");

        } else {
            System.out.println("Invalid Index !");
        }
    }

    void display() {
        if (a1.isEmpty()) {
            System.out.println("No Employee Found..");
        } else {
            for (int i = 0; i < a1.size(); i++) {
                Employee e = a1.get(i);
                System.out.println("Index " + i + " \n Name: " + e.getName() + " \n Age: " + e.getAge() + " \n Salary: "
                        + e.getSalary());
            }
        }
    }

    public static void main(String[] args) {
        QB215 qb = new QB215();

        while (true) {
            System.out.println(
                    "Enter Choice \n 1)Add Employee \n 2)Remove Employee \n 3)Update Employee \n 4)Display Employee \n 5)Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    qb.add();
                    break;

                case 2:
                    qb.remove();
                    break;

                case 3:
                    qb.update();
                    break;

                case 4:
                    qb.display();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter Valid Choice !!");
                    break;
            }

        }

    }
}
