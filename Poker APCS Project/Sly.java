public class Sly{
    private double handStrength;
    private double confidence = 0;
    private int funds = 10000;
    private Card c1;
    private Card c2;
    private Card r1;
    private Card r2;
    private Card r3;
    private int turn = 0; //3 turns beginning with 0 cards in the river
    private int deckSize = 52; 
    private int numberOfPlayers = 2;

    public Sly(Card hand1, Card hand2){
        c1 = hand1;
        c2 = hand2;
        deckSize-=(2*numberOfPlayers);
        handStrength = ((double) (c1.getVal() + c2.getVal())/2);
        System.out.println("Sly has been successfully initialized.");
    }

    public void alterFunds(int L){
        funds += L;
    }

    public int t1checkBet(Bet b){
        int betAmount = b.getbA();
        int slyt1Bet = 0;
        Hand t1Hand = new Hand(c1, c2, r1);
        if(t1Hand.checkPair() > 0 || t1Hand.checkThree() > 0 || handStrength >= 5){
            slyt1Bet = betAmount;
        }
        return(slyt1Bet);
    }

    public void addRiverCard(Card r){
        turn++;
        if(turn == 1){
            r1 = r;
        }
        else if(turn == 2){
            r2 = r;
        }
        else if(turn == 3){
            r3 = r;
        }
    }

    public int getHandCard1(){
        return(c1.getNum());
    }

    public int getHandCard2(){
        return(c2.getNum());
    }

    /*
    public void firstTurn(Card river1){
        r1 = river1;
        deckSize-=1;
        Hand turn1 = new Hand(c1, c2, r1);
        if(turn1.checkPair() > 0){
            Bet t1Bet = new Bet(fund/(1*confidence);
        }
    }
    */










}