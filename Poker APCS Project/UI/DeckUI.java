package UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckUI {
    private int cardsLeft;
    private CardUI[] deck = new CardUI[52];

    public DeckUI(){
        cardsLeft = 52;
        for (int i = 0; i < 4; i++){
            for (int ii = 0; ii < 13; ii++){
                deck[i*13+ii] = new CardUI(i, ii);
            }
        }
    }

    public DeckUI(CardUI[] deck){
        cardsLeft = deck.length;
        this.deck = deck;
    }

    public CardUI[] getDeck(){
        return deck;
    }

    public void shuffle() {
        List<CardUI> list = new ArrayList<>(Arrays.asList(deck));

        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            deck[i] = list.get(i);
        }
    }

    public void printDeck(){
        for (int cardHeightIterator = 0; cardHeightIterator < 7; cardHeightIterator++) {
            for (int i = 0; i < deck.length; i++) {
                System.out.print(deck[i].getCard()[cardHeightIterator] + " ");
            }
            System.out.println();
        }
    }

    public void blurt(){
        for (CardUI card : deck) card.blurt();
    }

    public DeckUI pop(int numCards){
        CardUI[] temp = new CardUI[deck.length - numCards];
        int i;
        for (i = 0; i < temp.length; i++)
            temp[i] = deck[i];
        CardUI[] ret = new CardUI[numCards];
        for (int ii = 0; i + ii < deck.length; ii++)
            ret[ii] = deck[i + ii];
        deck = temp;
        return new DeckUI(ret);
    }

    public CardUI pop(){
        CardUI[] temp = new CardUI[deck.length - 1];
        int i;
        for (i = 0; i < temp.length; i++)
            temp[i] = deck[i];
        CardUI ret = deck[i];
        deck = temp;
        return ret;
    }
}
