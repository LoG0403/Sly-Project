public class Hand{
    //royal flush, straight flush, four of a kind
    //full house, flush, straight, three of a kind
    //two pair, pair, high card

    //1-13 Hearts, 14-26 Diamonds, 27-39 Spades, Clubs 40-52

    //Card Number 1 = Card Value 2

    //10 = Jack, 11 = Queen, 12 = King, 13 = Ace
    
    Card blank1 = new Card(-1);
    Card blank2 = new Card(-2);

    private int h1;
    private int h2;
    private int r1;
    private int r2;
    private int r3;
        
    private Card h1card;
    private Card h2card;
    private Card r1card;
    private Card r2card;
    private Card r3card;
            
    private int h1suitCounter = 0;
    private int h2suitCounter = 0;
    private int r1suitCounter = 0;
    private int r2suitCounter = 0;
    private int r3suitCounter = 0;
        
        public Hand(Card hand1,Card hand2, Card riv1, Card riv2, Card riv3)
        {
            h1card = hand1;
            h2card = hand2;
            r1card = riv1;
            r2card = riv2;
            r3card = riv3;
            
            h1 = h1card.getVal(); //card val
            h2 = h2card.getVal();
            r1 = r1card.getVal();
            r2 = r2card.getVal();
            r3 = r3card.getVal();

            h1suitCounter = h1card.getSuit(); //getSuit() = val 0-3
            h2suitCounter = h2card.getSuit();
            r1suitCounter = r1card.getSuit();
            r2suitCounter = r2card.getSuit();
            r3suitCounter = r3card.getSuit();
        }

        public Hand(Card hand1,Card hand2, Card riv1, Card riv2)
        {
            h1card = hand1;
            h2card = hand2;
            r1card = riv1;
            r2card = riv2;
            r3card = blank1;
            
            h1 = h1card.getVal(); //card val
            h2 = h2card.getVal();
            r1 = r1card.getVal();
            r2 = r2card.getVal();
            r3 = r3card.getVal();

            h1suitCounter = h1card.getSuit(); //getSuit() = val 0-3
            h2suitCounter = h2card.getSuit();
            r1suitCounter = r1card.getSuit();
            r2suitCounter = r2card.getSuit();
            r3suitCounter = r3card.getSuit();
        }

        public Hand(Card hand1,Card hand2, Card riv1)
        {
            h1card = hand1;
            h2card = hand2;
            r1card = riv1;
            r2card = blank1;
            r3card = blank2;
            
            h1 = h1card.getVal(); //card val
            h2 = h2card.getVal();
            r1 = r1card.getVal();
            r2 = r2card.getVal();
            r3 = r3card.getVal();

            h1suitCounter = h1card.getSuit(); //getSuit() = val 0-3
            h2suitCounter = h2card.getSuit();
            r1suitCounter = r1card.getSuit();
            r2suitCounter = r2card.getSuit();
            r3suitCounter = r3card.getSuit();
        }

        public int checkPair(){
            int pair = 0;
    
            if(h1 == r1 || h1 == r2 || h1 == r3 || h2 == r1 || h2 == r2 || h2 == r3 || h1 == h2){
                pair = 2;
            }
            return(pair);
        }

        public int checkTwoPair(){
            int pair = 0;
    
            if((h1 == r1 || h1 == r2 || h1 == r3) && (h2 == r1 || h2 == r2 || h2 == r3)){
                pair = 3;
            }
            return(pair);
        }

        /*public int checkPair(){
        // this needs to be rewritten so 3 of a kind and 4 of a kind dont get counted in here
            int pair = 0;
            if(h1 == r1)
            {
                pair++;
            }
            if(h1 == r2)
            {
                pair++;
            }
            if(h1 == r3)
            {
                pair++;
            }
            if(h2 == r1)
            {
                pair++;
            }
            if(h2 == r2)
            {
                pair++;
            }
            if(h2 == r3)
            {
                pair++;
            }
            
            return(pair+1);
        }*/

        //I'm pretty sure this only needs to be checked with the h1 and h2 cards
        //three of a kind
        
        public int checkThree(){
            //System.out.println("hi");
            if(h1 == h2){
                if(h1 == r1 || h1 == r2 || h1 == r3)
                {
                    return(4);
                }
            }else if(h1 == r1)
            {
                if(h1 == h2 || h1 == r2 || h1 == r3)
                {
                    return(4);
                }
            }else if(h1 == r2)
            {
                if(h1 == h2 || h1 == r1 || h1 == r3)
                {
                    return(4);
                }
            }else if(h1 == r3)
            {
                if(h1 == h2 || h1 == r2 || h1 == r1)
                {
                    return(4);
                }
                //checking h2
            }if(h2 == r1){
                if(h2 == r2 || h1 == r3)
                {
                    return(4);
                }
            }else if(h2 == r2)
            {
                if(h2 == r3 || h1 == r2)
                {
                    return(4);
                }
            }else if(h2 == r2)
            {
                if(h1 == h2 || h1 == r1 || h1 == r3)
                {
                    return(4);
                }
            }else if(h2 == r3)
            {
                if(h1 == h2 || h1 == r2 || h1 == r1)
                {
                    return(4);
                }
            }
            return(1);
        }
        //straight
        public int checkStraight()
        {
            //is a bit strange and idk how to shorten it but basically its if 
            //h1+1 == (any other card) check if h1+2 == any other card and so on
            if(h1 + 1 == h2 || h1 + 1 == r1 || h1 + 1 == r2 || h1 + 1 == r3)
            {
                if(h1 + 2 == h2 || h1 + 2 == r1 || h1 + 2 == r2 || h1 + 2 == r3)
                {
                    if(h1 + 3 == h2 || h1 + 3 == r1 || h1 + 3 == r2 || h1 + 3 == r3)
                    {
                        if(h1 + 4 == h2 || h1 + 4 == r1 || h1 + 4 == r2 || h1 + 4 == r3)
                        {
                            return 5;
                        }
                    }
                }
            }
            //
            if(h2 + 1 == h1 || h2 + 1 == r1 || h2 + 1 == r2 || h2 + 1 == r3)
            {
                if(h2 + 2 == h1 || h2 + 2 == r1 || h2 + 2 == r2 || h2 + 2 == r3)
                {
                    if(h2 + 3 == h1 || h2 + 3 == r1 || h2 + 3 == r2 || h2 + 3 == r3)
                    {
                        if(h2 + 4 == h1 || h2 + 4 == r1 || h2 + 4 == r2 || h2 + 4 == r3)
                        {
                            return 5;
                        }
                    }
                }
            }
            //
            if(r1 + 1 == h2 || r1 + 1 == h1 || r1 + 1 == r2 || r1 + 1 == r3)
            {
                if(r1 + 2 == h2 || r1 + 2 == h1 || r1 + 2 == r2 || r1 + 2 == r3)
                {
                    if(r1 + 3 == h2 || r1 + 3 == h1 || r1 + 3 == r2 || r1 + 3 == r3)
                    {
                        if(r1 + 4 == h2 || r1 + 4 == h1 || r1 + 4 == r2 || r1 + 4 == r3)
                        {
                            return 5;
                        }
                    }
                }
            }
            //
            if(r2 + 1 == h2 || r2 + 1 == r1 || r2 + 1 == h1 || h1 + 1 == r3)
            {
                if(r2 + 2 == h2 || r2 + 2 == r1 || r2 + 2 == h1 || r2 + 2 == r3)
                {
                    if(r2 + 3 == h2 || r2+ 3 == r1 || r2 + 3 == h1 || r2 + 3 == r3)
                    {
                        if(r2 + 4 == h2 || r2 + 4 == r1 || r2 + 4 == h1 || r2 + 4 == r3)
                        {
                            return 5;
                        }
                    }
                }
            }
            //
            if(r3 + 1 == h2 || r3 + 1 == r1 || r3 + 1 == r2 || r3 + 1 == h1)
            {
                if(r3 + 2 == h2 || r3 + 2 == r1 || r3 + 2 == r2 || r3 + 2 == h1)
                {
                    if(r3 + 3 == h2 || r3 + 3 == r1 || r3 + 3 == r2 || r3 + 3 == h1)
                    {
                        if(r3 + 4 == h2 || r3 + 4 == r1 || r3 + 4 == r2 || r3 + 4 == h1)
                        {
                            return 5;
                        }
                    }
                }
            }
            return 0;
        }
        public int checkFlush(){
            //this is pretty simple, just lick checking to make sure its all the same suit
            if(h1suitCounter == h2suitCounter && h1suitCounter == r1suitCounter && h1suitCounter == r2suitCounter && h1suitCounter == r3suitCounter)
            {
                return 6;
            }
            return 0;
        }
        
        public int checkFullHouse(){
            if(h1 == h2 || h1 == r1 || h1 == r2 || h1 == r3)
            {
                //cheking if each card has a 3 of a kind
                if ((h2 == r1 && h2 == r2)||(r1 == r2 && r1 == r3) || (h2 == r2 && h2 == r3)||(h2 == r1 && h2 == r3))
                {
                    return 7;
                }
            }
            
            if(h2 == h1 || h2 == r1 || h2 == r2 || h2 == r3)
            {
                //cheking if each card has a 3 of a kind
                if ((h1 == r1 && h1 == r2)||(r1 == r2 && r1 == r3) || (h1 == r2 && h1 == r3)||(h1 == r1 && h1 == r3))
                {
                    return 7;
                }
            }
            
            if(r1 == h2 || r1 == h1 || r1 == r2 || r1 == r3)
            {
                //cheking if each card has a 3 of a kind
                if ((h1 == h2 && h2 == r2)||(h1 == r2 && h1 == r3) || (h2 == r2 && h2 == r3)||(h2 == h1 && h2 == r3))
                {
                    return 7;
                }
            }
            
            if(r2 == h2 || r2 == r1 || r2 == h1 || r2 == r3)
            {
                //cheking if each card has a 3 of a kind
                if ((h2 == r1 && h2 == h1)||(r1 == h1 && r1 == r3) || (h2 == h1 && h2 == r3)||(h2 == r1 && h2 == r3))
                {
                    return 7;
                }
            }
            
            if(r3 == h2 || r3 == r1 || r3 == r2 || h1 == r3)
            {
                //cheking if each card has a 3 of a kind
                if ((h2 == r1 && h2 == r2)||(r1 == r2 && r1 == h1) || (h2 == r2 && h2 == h1)||(h2 == r1 && h2 == h1))
                {
                    return 7;
                }
            }
            return 0;
            
        }
        
        public int checkFour(){
            if(h1 == h2 && h1 == r1 && h1 == r2)
            {
                return 8;
            }
            if(h1 == r3 && h1 == r1 && h1 == r2)
            {
                return 8;
            }
            if(h1 == h2 && h1 == r3 && h1 == r2)
            {
                return 8;
            }
            if(h1 == h2 && h1 == r1 && h1 == r3)
            {
                return 8;
            }
            if(r3 == h2 && r3 == r1 && r3 == r2)
            {
                return 8;
            }
            return 0;
        }


        public int checkRoyalFlush(){
            //returns ten if true
            if(h1suitCounter == h2suitCounter && h1suitCounter == r1suitCounter && h1suitCounter == r2suitCounter && h1suitCounter == r3suitCounter){
                if((h1 == 13 || h1 == 12  || h1 == 11  || h1 == 10  || h1 == 9) && h1 != h2 && h1 != r1 && h1 != r2 && h1 != r3){
                    if((h2 == 13 || h2 == 12  || h2 == 11  || h2 == 10  || h2 == 9) && h2 != h1 && h2 != r1 && h2 != r2 && h2 != r3){
                        if((r1 == 13 || r1 == 12  || r1 == 11  || r1 == 10  || r1 == 9) && r1 != h1 && r1 != h2 && r1 != r2 && r1 != r3){
                            if((r2 == 13 || r2 == 12  || r2 == 11  || r2 == 10  || r2 == 9) && r2 != h1 && r2 != h2 && r2 != r1 && r2 != r3){
                                if((r3 == 13 || r3 == 12  || r3 == 11  || r3 == 10  || r3 == 9) && r3 != h1 && r3 != h2 && r3 != r1 && r3 != r2){
                                    return(10);
                                }
                            }
                        }
                    }
                }
            }
            return(0);
        }


        public int checkStraightFlush(){
            //returns nine if true
            if(h1suitCounter == h2suitCounter && h1suitCounter == r1suitCounter && h1suitCounter == r2suitCounter && h1suitCounter == r3suitCounter)
            {
                if(h1 + 1 == h2 || h1 + 1 == r1 || h1 + 1 == r2 || h1 + 1 == r3)
                {   
                    if(h1 + 2 == h2 || h1 + 2 == r1 || h1 + 2 == r2 || h1 + 2 == r3)
                    {
                        if(h1 + 3 == h2 || h1 + 3 == r1 || h1 + 3 == r2 || h1 + 3 == r3)
                        {
                            if(h1 + 4 == h2 || h1 + 4 == r1 || h1 + 4 == r2 || h1 + 4 == r3)
                            {
                            return 9;
                            }
                        }
                    }
                }
            //
                if(h2 + 1 == h1 || h2 + 1 == r1 || h2 + 1 == r2 || h2 + 1 == r3)
                {
                    if(h2 + 2 == h1 || h2 + 2 == r1 || h2 + 2 == r2 || h2 + 2 == r3)
                    {
                        if(h2 + 3 == h1 || h2 + 3 == r1 || h2 + 3 == r2 || h2 + 3 == r3)
                        {
                            if(h2 + 4 == h1 || h2 + 4 == r1 || h2 + 4 == r2 || h2 + 4 == r3)
                            {
                            return 9;
                            }
                        }
                    }
                }
            //
                if(r1 + 1 == h2 || r1 + 1 == h1 || r1 + 1 == r2 || r1 + 1 == r3)
                {
                    if(r1 + 2 == h2 || r1 + 2 == h1 || r1 + 2 == r2 || r1 + 2 == r3)
                    {
                        if(r1 + 3 == h2 || r1 + 3 == h1 || r1 + 3 == r2 || r1 + 3 == r3)
                        {
                            if(r1 + 4 == h2 || r1 + 4 == h1 || r1 + 4 == r2 || r1 + 4 == r3)
                            {
                            return 9;
                            }
                        }
                    }
                }
            //
                if(r2 + 1 == h2 || r2 + 1 == r1 || r2 + 1 == h1 || h1 + 1 == r3)
                {
                    if(r2 + 2 == h2 || r2 + 2 == r1 || r2 + 2 == h1 || r2 + 2 == r3)
                    {
                        if(r2 + 3 == h2 || r2+ 3 == r1 || r2 + 3 == h1 || r2 + 3 == r3)
                        {
                            if(r2 + 4 == h2 || r2 + 4 == r1 || r2 + 4 == h1 || r2 + 4 == r3)
                            {
                                return 9;
                            }
                        }
                    }
                }
            //
                if(r3 + 1 == h2 || r3 + 1 == r1 || r3 + 1 == r2 || r3 + 1 == h1)
                {
                    if(r3 + 2 == h2 || r3 + 2 == r1 || r3 + 2 == r2 || r3 + 2 == h1)
                    {
                        if(r3 + 3 == h2 || r3 + 3 == r1 || r3 + 3 == r2 || r3 + 3 == h1)
                        {
                            if(r3 + 4 == h2 || r3 + 4 == r1 || r3 + 4 == r2 || r3 + 4 == h1)
                            {
                                return 9;
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }        
