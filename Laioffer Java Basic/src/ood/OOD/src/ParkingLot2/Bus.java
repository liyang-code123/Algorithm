package ood.OOD.src.ParkingLot2;

public class Bus extends Vehicle{
    public Bus() {
        size = VehicleSize.Bus;
        spotNeeded = 5;
    }

    @Override
    protected boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
