package ood.VendingMachine2.src;

public class NotSufficientCoinException extends Exception {
    private String message;

    public NotSufficientCoinException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
