package ood.OOD.src.ParkingLot2;

public class Motorcycle extends Vehicle{
    public Motorcycle() {
        size = VehicleSize.Motorcycle;
        spotNeeded = 1;
    }

    @Override
    protected boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}
