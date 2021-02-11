package javadesign;

public class Employee {
    public String name;
    public String id;
    public int age;
    protected int salary;
    protected int level;

    public void printInfo() {
        System.out.println("Name: " + name + "; Age: " + age + "; ID: " + id);
    }
}


