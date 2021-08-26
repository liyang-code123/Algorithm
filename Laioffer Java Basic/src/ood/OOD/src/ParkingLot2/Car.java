package ood.OOD.src.ParkingLot2;

public class Car extends Vehicle{
    public Car() {
        size = VehicleSize.Compact;
        spotNeeded = 2;
    }

    @Override
    protected boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Compact;
    }
}
