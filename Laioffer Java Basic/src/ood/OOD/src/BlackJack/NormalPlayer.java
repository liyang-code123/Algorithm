package ood.OOD.src.BlackJack;

import java.util.List;

public class NormalPlayer {
    private Hand hand;
    private BlackJack game;
    private int totalBets = 10000;
    private int currentBets;
    private boolean stopDealing;
    private int id;

    public NormalPlayer(int id, int currentBets) {
        this.id = id;
        this.currentBets = currentBets;
        hand = new Hand();
        try {
            placeBets(currentBets);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void joinGame(BlackJack game) {
        this.game = game;
        game.addPlayer(this);
    }

    public void placeBets(int amount) throws Exception {
        if (totalBets < amount) {
            throw new Exception("Not enough money");
        }
        currentBets = amount;
        totalBets = totalBets - currentBets;
    }

    public void insertCard(Card card) {
        hand.insertCard(card);
    }

    public void dealNextCard() {
        this.insertCard(game.dealNextCard());
    }

    public void stopDealing() {
        stopDealing = true;
    }

    public int getBestValue() {
        return hand.getBestValue();
    }

    public int getCurrentBets() {
        return currentBets;
    }

    public void win() {
        totalBets += (currentBets * 2);
        currentBets = 0;
    }

    public void lose() {
        currentBets = 0;
    }

    public String printPlayer() {
            return hand.printHand() + ", current bets: " + currentBets + ", total bets: " + totalBets + "\n";
    }
}

