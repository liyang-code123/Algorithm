package ood.VendingMachine2.src;

public class SoldOutException extends Exception {
    private String message;

    public SoldOutException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
