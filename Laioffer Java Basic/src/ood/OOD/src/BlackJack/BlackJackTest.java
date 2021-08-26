package ood.OOD.src.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackTest {
    public static void main(String[] args) {
        BlackJack bj = new BlackJack();
        List<Card> cards = new ArrayList<>();

        Card card0 = new Card(1);
        Card card1 = new Card(2);
        Card card2 = new Card(3);
        Card card3 = new Card(4);
        Card card4 = new Card(5);
        Card card5 = new Card(6);
        Card card6 = new Card(7);
        Card card7 = new Card(8);
        Card card8 = new Card(9);
        Card card9 = new Card(10);
        Card card10 = new Card(11);
        Card card11 = new Card(12);
        Card card12 = new Card(13);
        Card card13 = new Card(10);
        Card card14 = new Card(11);
        Card card15 = new Card(12);
        Card card16 = new Card(13);

        cards.add(card0);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);
        cards.add(card8);
        cards.add(card9);
        cards.add(card10);
        cards.add(card11);
        cards.add(card12);
        cards.add(card13);
        cards.add(card14);
        cards.add(card15);
        cards.add(card16);

        bj.initCards(cards);

        NormalPlayer p1 = new NormalPlayer(1, 500);
        NormalPlayer p2 = new NormalPlayer(2, 1000);
        NormalPlayer p3 = new NormalPlayer(3, 3000);
        NormalPlayer p4 = new NormalPlayer(3, 4000);
        p1.joinGame(bj);
        p2.joinGame(bj);
        p3.joinGame(bj);
        p4.joinGame(bj);


        Dealer dealer = new Dealer();
        dealer.setGame(bj);

        bj.dealInitialCards();
        p1.dealNextCard();
        p1.stopDealing();
        p2.dealNextCard();
        p2.stopDealing();
        p3.dealNextCard();
        p3.stopDealing();
        p4.dealNextCard();
        p4.stopDealing();

        dealer.dealNextCard();
        dealer.dealNextCard();
        dealer.dealNextCard();

        bj.compareResult();

        System.out.println(dealer.printDealer());
        System.out.println(p1.printPlayer());
        System.out.println(p2.printPlayer());
        System.out.println(p3.printPlayer());
        System.out.println(p4.printPlayer());

    }
}
