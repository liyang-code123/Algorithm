package javadesign;

public class Manager extends Employee{
    public void print() {
        System.out.println("Name: " + name + "; Age: " + age + "; ID: " + id);
        System.out.println("Salary: " + salary);
        printInfo();
    }

    Employee e = new Employee();
//    System.out.println("Name: " + e.name + ";Age: " + e.age + ";ID: " + e.id);

    Manager m = new Manager();
//    System.out.println("Name: " + m.name + ";Age: " + m.age + ";ID: " + m.id);
}
