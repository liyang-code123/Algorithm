package ood.parkinglot;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    // if the spot can fit the vehicle
    boolean fit(Vehicle v) {
        // size.getSize() is the ParkingSpot size.
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }

    void park(Vehicle v) {
        currentVehicle = v;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getVehicle() {
        return currentVehicle;
    }
}
