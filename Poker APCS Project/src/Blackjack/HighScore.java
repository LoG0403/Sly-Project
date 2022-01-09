package src.Blackjack;

public class HighScore {
    private String player;
    private int score;

    public HighScore(String player, int score){
        this.player = player;
        this.score = score;
    }

    public String getPlayer(){
        return player;
    }

    public int getScore(){
        return score;
    }
}
