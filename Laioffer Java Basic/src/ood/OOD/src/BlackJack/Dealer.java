package ood.OOD.src.BlackJack;

public class Dealer {
    private BlackJack game;
    private Hand hand;
    private int currentBets = 10000;

    public Dealer() {
        hand = new Hand();
    }

    public void setGame(BlackJack game) {

        this.game = game;
        game.addDealer(this);
    }

    public void insertCard(Card card) {
        hand.insertCard(card);
    }

    public void dealNextCard() {
        this.insertCard(game.dealNextCard());
    }

    public boolean largerThan(NormalPlayer p) {
        return hand.getBestValue() >= p.getBestValue();
    }

    public void updateBets(int amount) {
        currentBets += amount;
    }

    public String printDealer() {
        return "Dealer" + hand.printHand() + ", total bets: " + currentBets + "\n";
    }

}
