package ood.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot (4, 10);
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v = i % 2 == 0 ? new Car() : new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpot(v);
            // the parking lot only has 40 spots(4 x 10)
            if (i < 40) {
                assert hasSpot;
                assert lot.park(v);
            } else {
                assert !hasSpot;
                assert !lot.park(v);
            }
        }
        assert list.size() == 50;
        int i = 0;
//        for (Vehicle v : list) {
//            assert i >= 40 || lot.leave(v);
//            i++;
//        }
        while (i < 50) {
            if (i < 10) {
                if (lot.leave(list.get(i))) {
                    assert lot.park(list.get(i + 40));
                }
            }
            assert i >= 40;
        }
    }
}



