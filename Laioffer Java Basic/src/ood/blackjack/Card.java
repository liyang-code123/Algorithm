package ood.blackjack;

public class Card {
    private final FaceValue fV;
    private final Suit suit;

    public Card(FaceValue c, Suit s) {
        fV = c;
        suit = s;
    }

    public int value() {
        return fV.getValue();
    }

    public Suit suit() {
        return suit;
    }
}
