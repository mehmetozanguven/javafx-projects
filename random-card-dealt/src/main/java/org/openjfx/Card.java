package org.openjfx;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Card {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 13;
    enum Suit {
        CLUBS(1), DIAMONDS(2), HEARTS(3),  SPADES(4)
        ;
        public final int value;

        Suit(int value) {
            this.value = value;
        }

    }

    private static final List<Suit> SUITS = List.of(Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS);
    public final int value;
    public final Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public static Card getRandomCard() {
        int cardNumber = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER+1);
        Suit suit = SUITS.get(ThreadLocalRandom.current().nextInt(0, SUITS.size()));
        return new Card(cardNumber, suit);
    }

    @Override
    public String toString() {
        String cardValue = String.valueOf(value);
        if (value == 11) {
            cardValue = "Jack";
        } else if (value == 12) {
            cardValue = "Queen";
        } else if (value == 13) {
            cardValue = "King";
        }

        return "Card{" +
                "value=" + cardValue +
                ", suit=" + suit +
                '}';
    }
}
