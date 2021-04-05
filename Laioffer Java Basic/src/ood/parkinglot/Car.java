package ood.parkinglot;

public class Car extends Vehicle{
    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }

    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.getSize());
    }
}
