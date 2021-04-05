package ood.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    // final is used to prevent it from assigning a new variable to the list.
    private final List<ParkingSpot> spots;

    Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        // 0 - numOfSpots/2 are used for compact; numOfSpots/2 + 1 to numOfSpots are used for large.
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        // unmodifiableList is used to make the list immutable.
        spots = Collections.unmodifiableList(list);
    }

    boolean hasSpot(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot s : spots) {
            if(s.fit(v)) {
                s.park(v);
                return true;
            }
        }
        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.getVehicle() == v) {
                s.leave();
                return true;
            }
        }
        return false;
    }
}
