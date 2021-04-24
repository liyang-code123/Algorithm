package ood.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {
    /*
    if all the possibleScores are over 21,
    then return the minimum number
    if all the possibleScores have both under 21 and over 21,
    then return maximum number under 21
     */
    @Override
    public int score() {
        List<Integer> scores = possibleScores(); // [22, 30, 23]
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score; // minOver: 22
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score; // maxUnder: 12
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    } // maxUnder: 12

    // 2, 4, Ace --> [7, 17]
    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card card : cards) {
            updateScores(card, scores);
        }
        return scores;
    }

    // 2, 4, Ace --> [7, 17] + Ace [1, 11] --> [10, 20]
    private void updateScores(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card); //[2, 4, Q, Ace]
        if (scores.isEmpty()) {
            for (int score : toAdd) {
                scores.add(score);
            }
        } else {
            final int length = scores.size(); // 2
            for (int i = 0; i < length; i++) {
                int oldScore = scores.get(i);// 7, 17
                scores.set(i, oldScore + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
            }
        }
    }

    // [2], [4], [10], [1, 11]
    private int[] getScores(Card card) {
        if (card.value() > 1) {
            return new int[]{Math.min(card.value(), 10)};
        } else {
            return new int[]{1, 11};
        }
    }
}
