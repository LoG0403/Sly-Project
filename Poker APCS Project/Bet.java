//Allows Sly and user to place bets

public class Bet{

    private int bA;
    private int pool = 0;

    public Bet(int betAmount, Sly s){
        bA = betAmount;
        pool+= bA;
    }

    public int getPool(){
        return pool;
    }

    public int getbA(){
        return bA;
    }
}