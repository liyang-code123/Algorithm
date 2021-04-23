package ood.blackjack;

public enum Suit {
    Club(1), // meihua
    Heart(2),// hongtao
    Spade(3), // heitao
    Diamond(4); // fangpian

    private final int value;
    Suit(int value) {
        this.value = value;
    }

//    public int getValue() {
//        return value;
//    }
}
