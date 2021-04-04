package ood.parkinglot;

public enum Vehicle {
    Car("Car", 2),
    Truck("Truck", 10);
    int size;

    Vehicle(String s, int i) {
        size = i;
    }

    public static void main(String[] args) {
        Vehicle v = Truck;
        System.out.println(v.ordinal());
        System.out.println(v.name());
        System.out.println(v.size);
    }
}
