import java.util.Scanner;
import java.time.Year;
import java.util.Random;

//import UI.DeckUI;

public class Main {
    public static void main(String[] args) {        
        //1-13 Hearts, 14-26 Diamonds, 27-39 Spades, Clubs 40-52
        //1 = 2, 2 = 3, etc, etc
        //10 = Jack, 11 = Queen, 12 = King, 13 = Ace
        
        /*Card aceOfClubs = new Card(52);
        Card threeOfSpades = new Card(28);
        Card queenOfHearts = new Card(11);
        System.out.println(aceOfClubs.getVal());
        System.out.println(threeOfSpades.getVal());
        System.out.println(queenOfHearts.getVal());
        System.out.println(aceOfClubs.getSuit());*/

        Scanner input = new Scanner(System.in);

        Random coin = new Random();
        int coinToss = 1; //coin.nextInt(2) + 1;

        int pool = 0;

        int ante = 500;

        Card river1;
        Card river2;
        Card river3;

        //print rules
        System.out.println("");
        System.out.println("");
        System.out.println("Welcome to Sly's Poker Casino!");
        System.out.println("Here you'll be able to play virtually endless games of simulated poker against an Artifical Intelligence named Sly, \ndeveloped by Kian Benner, Kaito Burkheimer, Max Lebrun, and Nadir Elyaddasse.");
        System.out.println("View the rules here: https://www.wikihow.com/Play-Poker");
        //ask if player wants to start a game
        System.out.println("Would you like to start a game? (Y/N)");
        String startGame = input.nextLine();
        if(startGame.equals("Y")){
            //initialize deck
            Deck d1 = new Deck();
            //initialize player
            System.out.print("Enter your name: ");
            String uName = input.nextLine();
            Player p1 = new Player(uName, d1.getCard(), d1.getCard());
            //initialize AI
            Card slyc1 = d1.getCard();
            Card slyc2 = d1.getCard();
            Sly sly = new Sly(slyc1, slyc2);
            //Sly sly = new Sly(d1.getCard(), d1.getCard());
            //establish turn order, create river
            System.out.println("Dealing hands...");
            river1 = d1.getCard();
            river2 = d1.getCard();
            river3 = d1.getCard();
            //print round1 UI
            System.out.println("Ante of: " + ante);
            p1.alterFunds(-ante);
            sly.alterFunds(-ante);
            pool+=ante*2;
            sly.addRiverCard(river1);
            if(coinToss == 1){
                System.out.println(uName + " is on the play for the first round.");
                p1.firstTurn(river1, sly);
                pool += p1.getPoolChange();
                System.out.println("The current pool is " + pool);


                //TESTING
                System.out.println("\n \n \nTESTING");
                System.out.println("------------------");
                System.out.println(slyc1.getNum());
                System.out.println(slyc2.getNum());
                System.out.println(sly.getHandCard1());
                System.out.println(sly.getHandCard2());
                Card test;
                for(int i = 0; i<20; i++){
                    test = d1.getCard();
                    System.out.println(test.getNum() + ", " + test.getVal());
                }
            }
            else if(coinToss == 2){
                System.out.println("Sly is on the play for the first round.");
            }
        }
        
        //print("dealing...")
        //print spacer
        //print hand and UI
        //UI must include: deck + hand + ante + current funds + turn count + AI/playername goes first
        //turn 0: initialize Sly, generate confidence, raise funds
        //turn 1: flip first card of the river, 
    }
}
