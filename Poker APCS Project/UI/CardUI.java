package UI;

public class CardUI {
    private final int suitNum;
    private final int cardNum;
    private String[] card;
    public static final String[] suits = {"♠", "♥", "♦", "♣"};
    public static final String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] cardsA = {"A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "J ", "Q ", "K "};
    public static final String[] cardsB = {" A", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K"};

    public CardUI(int suitNum, int cardNum){
        this.suitNum = suitNum;
        this.cardNum = cardNum;
        this.card = new String[]{"┌─────────┐",
                "|" + cardsA[cardNum] + "       |",
                "|         |",
                // "|         |",
                "|    " + suits[suitNum] + "    |",
                "|         |",
                // "|         |",
                "|       " + cardsB[cardNum] + "|",
                "└─────────┘"
        };
    }

    public int getSuitNum(){
        return suitNum;
    }

    public int getCardNum(){
        return cardNum;
    }

    public void setCard(boolean flipped){
        if (flipped) {
            this.card = new String[]{"┌─────────┐",
                                     "|▓▓▓▓▓▓▓▓▓|",
                                     "|▓▓▓▓▓▓▓▓▓|",
                                     "|▓▓▓▓▓▓▓▓▓|",
                                     "|▓▓▓▓▓▓▓▓▓|",
                                     "|▓▓▓▓▓▓▓▓▓|",
                                     "└─────────┘"
            };
        } else {
            this.card = new String[]{"┌─────────┐",
                    "|" + cardsA[cardNum] + "       |",
                    "|         |",
                    // "|         |",
                    "|    " + suits[suitNum] + "    |",
                    "|         |",
                    // "|         |",
                    "|       " + cardsB[cardNum] + "|",
                    "└─────────┘"
            };
        }
    }

    public String[] getCard(){
        return card;
    }

    public void printCard(){
        for (String s : card) {
            System.out.println(s);
        }
    }

    public void blurt(){
        System.out.println(suits[suitNum] + " " + cards[cardNum]);
    }
}
