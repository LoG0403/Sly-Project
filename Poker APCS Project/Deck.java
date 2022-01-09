import java.util.Random;

public class Deck {
    
    private int[] numCards = new int[53];
    private int[] cardsUsed = new int[53];
    
    int cardCount = 52;

    public Deck(){
        for(int x = 1; x<=52; x++){
            numCards[x] = x;
            //System.out.println(numCards[x]);
        }
    }

    public Card getCard(){
        Random rn = new Random();
        int randCardNum = rn.nextInt(52) + 1;
        //initailizes random number

        Card newCard = new Card(-3);
        //makes functionally blank card
        
        boolean loop = true;

        while(loop == true){
            
            for(int n = 0; n < cardsUsed.length - 1; n++){
                if(randCardNum == cardsUsed[n]){
                    while(randCardNum == cardsUsed[n]){
                        randCardNum = rn.nextInt(52) + 1;
                    }
                }
            }
            
            for(int m = 0; m < numCards.length - 1; m++){
                if(randCardNum == numCards[m]){
                    //for each card in the deck, checks if it is equal to the 
                    //random number
                    newCard.changeNum(randCardNum);
                    cardsUsed[randCardNum] = randCardNum;
                    //updates blank card with real value when found
                    //numCards = removeTheElement(numCards, randCardNum); //THIS LINE MUST FAIL
                    //because the function is tested 52 times and there are cards remaining
                    //the correct card is not being removed each time
                    
                    //sets value of numCards to itself with the element
                    //equivalent to the random number removed
                    loop = false;
                    cardCount--;
                    return(newCard);
                }
                else{
                    randCardNum = rn.nextInt(52) + 1;
                }
            }    
        }
        return(newCard);
    }

    public static int[] removeTheElement(int[] arr, int index)
    {
 
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
            || index >= arr.length) {
 
            return arr;
        }
 
        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];
 
        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }
 
            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }
 
        // return the resultant array
        return anotherArray;
    }
    
    public int getNumCards(){
        return(cardCount);
    }
}