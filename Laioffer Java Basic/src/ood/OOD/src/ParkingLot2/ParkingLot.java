package ood.OOD.src.ParkingLot2;

import javafx.util.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class ParkingLot {
    private List<Level> level;
    private List<ParkingSpot> spot;
    private int spotId;
    private Vehicle v;
    private VehicleSize size;
    private float rate;

    public boolean isAvailable() {
        return v == null;
    }

    public List<ParkingSpot> findAvailable(Vehicle v) {
    }

    public float getPrice(Vehicle v) {

    }

    public boolean parkVehicle(Vehicle v) {
        for (int i = 0; i < level.size(); i++) {
            if (level.get(i).parkVehicle(v)) {
                System.out.println("Successful parked at level" + level + "with spot number" + spotId);
                return true;
            }
        }
        System.out.println("We are sorry that there are no available spot at the moment.");
        return false;
    }

    public String leaveVehicle(Vehicle v) {

    }
}



