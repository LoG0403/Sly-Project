public class Card {
    private int num;

    public Card(int n){
        num = n;
    }
    public int getNum(){
        return(num);
    }

    public int getVal(){
        if(num>0 && num%13 != 0){
            return(num%13+1);
        }
        else if(num<0){
            return(num);
        }
        else{
            return(14);
        }
    }

    public int getSuit(){
        if(num<0){
            return(-100+num);
        }
        else{
            int suit = -1;
            while(num > 0){
                num-=13;
                suit++;
            }
            return(suit);
        }
    }

    public void changeNum(int x){
        num=x;
    }
}