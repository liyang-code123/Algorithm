package ood.OOD.src.ParkingLot2;

public class ParkingSpot {
    private Vehicle v;
    private Level level;
    private int spotId;
    private boolean isHandicapped;
    private boolean isOccupied;
    private VehicleSize size;


    public boolean isAvailable() {
        return v == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        return isAvailable() && v.canFitInSpot(this);
    }

    public VehicleSize getSize() {
        return size;
    }


}
