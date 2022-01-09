package Blackjack;

import java.io.IOException;

import UI.Deck;

public class MyProgram {
    public static void main(String[] args) throws IOException {
        /** Test code for HSManager
        // Simple testing code which wipes the log files, then adds some entries, then gets the top 4 scores and prints them
        HSManager.wipeHS();
        HSManager.addHS("Bob", 1337);
        HSManager.addHS("Tom", 54321);
        HSManager.addHS("Tim", 6);
        HSManager.addHS("Tam", 90);
        HSManager.addHS("Tum", 9001);

        HighScore[] scores = HSManager.getHS(4);
        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i].getPlayer() + " " + scores[i].getScore());
         **/

        Deck monarch = new Deck();
        monarch.shuffle();
        System.out.println("______________________________________________\n                    RIVER                    \n______________________________________________\n");
        Deck river = monarch.pop(3);
        river.getDeck()[1].setCard(true);
        river.getDeck()[2].setCard(true);
        river.printDeck();
        System.out.println("______________________________________________\n                    HAND                    \n______________________________________________\n");
        Deck hand = monarch.pop(2);
        hand.printDeck();
    }
}
