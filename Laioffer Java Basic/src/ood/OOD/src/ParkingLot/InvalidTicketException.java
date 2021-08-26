package ood.OOD.src.ParkingLot;

public class InvalidTicketException extends Exception{
    public InvalidTicketException() {
        super();
    }

    public InvalidTicketException(String message) {
        super(message);
    }
}
