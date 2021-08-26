package ood.OOD.src.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private Dealer dealer;
    private List<NormalPlayer> players;
    private List<Card> cards;

    public BlackJack() {
        players = new ArrayList<>();
        dealer = new Dealer();
    }

    public void initCards(List<Card> cards) {
        this.cards = cards;
    }
    public void addPlayer(NormalPlayer p) {
        players.add(p);
    }
    public void addDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void shuffle() {
    }

    public void dealInitialCards() {
        for (NormalPlayer player : players) {
            player.insertCard(dealNextCard());
        }
        dealer.insertCard(dealNextCard());

        for (NormalPlayer player : players) {
            player.insertCard(dealNextCard());
        }
        dealer.insertCard(dealNextCard());
    }

    public Card dealNextCard() {
        Card card = cards.remove(0);
        return card;
    }

    public void compareResult() {
        for (NormalPlayer p : players) {
            if (dealer.largerThan(p)) {
                dealer.updateBets(p.getCurrentBets());
                p.lose();
            } else {
                dealer.updateBets(-p.getCurrentBets());
                p.win();
            }
        }
    }
}