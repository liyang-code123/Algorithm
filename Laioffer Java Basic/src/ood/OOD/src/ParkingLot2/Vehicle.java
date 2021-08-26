package ood.OOD.src.ParkingLot2;

public abstract class Vehicle {
    protected VehicleSize size;
    protected int spotNeeded;
    private boolean isHandicapped;
    private int id;
    protected abstract boolean canFitInSpot(ParkingSpot spot);

    public VehicleSize getSize() {
        return size;
    }
}
