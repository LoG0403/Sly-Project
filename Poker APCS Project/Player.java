import java.util.Scanner;

public class Player {
    private String name;
    private int funds = 10000;
    private Card hc1;
    private Card hc2;
    private Card ri1;
    private Card ri2;
    private Card ri3;

    private Sly local;

    private int poolChange = 0;

    Scanner input = new Scanner(System.in);
    
    public Player(String n, Card handContent1, Card handContent2){
        name = n;
        hc1 = handContent1;
        hc2 = handContent2;
        System.out.println("Hello " + n + "! You currently have $" + funds + " available to you.");
    }

    public void firstTurn(Card r1, Sly sly){
        ri1 = r1;
        local = sly;
        System.out.println("Enter " + '"' + "CHECK" + '"' + ", " + '"' + "BET" + '"' + ", or " + '"' + "FOLD" + '"' + " to complete the associated action: ");
        String choice = input.nextLine();
        while(true){
            if(choice.equals("BET")){
                System.out.println("How much would you like to wager? ");
                int betAmount = input.nextInt();
                if(betAmount <= funds && betAmount > 0){
                    Bet t1Bet = new Bet(betAmount, local);
                    if(local.t1checkBet(t1Bet) == betAmount){
                        funds-=betAmount;
                        local.alterFunds(-betAmount);
                        poolChange += t1Bet.getPool()*2;
                        System.out.println("Sly and " + name + " Successfully bet $" + betAmount);
                        System.out.println("Ending " + name + "'s" + " turn");
                        break;
                    }
                    else{
                        System.out.println("Sly has folded.");
                        break;
                    }
                }
                else{
                    System.out.println("Bet amount is greater than available funds.");
                    System.out.println("You have $" + funds + " at your disposal.");
                }
            }
            else if(choice.equals("FOLD")){
                System.out.println("Folding...");
                //game.newGame(player, sly);
                break;
            }
            else if(choice.equals("CHECK")){
                System.out.println("Ending " + name + "'s" + " turn");
                break;
            }
            else if(!choice.equals("CHECK")){
                System.out.println("Invalid input. Please enter an appropriate command: ");
                choice = input.nextLine();
            }
        }
    }

    public int getFunds(){
        return funds;
    }

    public void alterFunds(int change){
        funds+=change;
    }

    public int getPoolChange(){
        return poolChange;
    }
}
