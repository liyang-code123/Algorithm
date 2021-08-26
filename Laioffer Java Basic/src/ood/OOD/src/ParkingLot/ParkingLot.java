package ood.OOD.src.ParkingLot;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class ParkingLot {
    private List<Level> level;
    private float hourlyRate;

    public int getAvailableCount(){
        return 0;
    }

    public List<Spot> findSportsForVehicle(Vehicle v) throws ParkingLotFullException {
        return null;
    }

    public Ticket parkVehicle(Vehicle v) throws InvalidTicketException {
        if ( v== null) {
            throw new InvalidTicketException("ticket is invalid");
        }
        return null;
    }

    public void clearSpot(Ticket t) {

    }

    private float calculatePrice(Ticket t) {
        return 0;
    }

}
