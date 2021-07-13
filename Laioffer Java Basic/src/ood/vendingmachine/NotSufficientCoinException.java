package ood.vendingmachine;

public class NotSufficientCoinException extends RuntimeException{
    private String message;

    public NotSufficientCoinException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
