package ood.vendingmachine;

public class NotFullyPaidException extends RuntimeException{
    private String message;
    private int remaining;

    public NotFullyPaidException(String message, int remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public int getRemaining() {
        return remaining;
    }

    @Override
    public String getMessage() {
        return message + remaining;
    }
}
