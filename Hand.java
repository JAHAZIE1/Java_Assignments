// 13193920
// jahazi01@student.bbk.ac.uk

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


 class Card {

     public String getSuit(int s) {
         String answer = "";

         if (s == 0) {
             answer ="Clubs";
         } else if (s == 1) {
             answer = "Diamonds";
         } else if (s == 2) {
             answer = "Hearts";
         } else if (s == 3) {
             answer = "Spades";
         }
         return answer;
     }

     public String getValue (int v) {
         String answer = String.valueOf(v);
         if (v == 1) {
             answer ="Ace";
         } else if (v == 11) {
             answer = "Jack";
         } else if (v == 12) {
             answer = "Queen";
         } else if (v == 13) {
             answer = "King";
         }
         return answer;
     }
 }

public class Hand extends Card
{
    int c1Value;
    int c1Suit;
    int c2Value;
    int c2Suit;
    int c3Value;
    int c3Suit;
    int c4Value;
    int c4Suit;
    int c5Value;
    int c5Suit;

    Hand( String str ) {
        String[] group;
        group = str.split(" ");

        for (int i = 0; i < 10; i++) {
            String p = group[i];
            if (i == 0) {
                this.c1Value = Integer.parseInt(p);
            } else if (i == 1) {
                this.c1Suit = Integer.parseInt(p);
            } else if (i == 2) {
                this.c2Value = Integer.parseInt(p);
            } else if (i == 3) {
                this.c2Suit = Integer.parseInt(p);
            } else if (i == 4) {
                this.c3Value = Integer.parseInt(p);
            } else if (i == 5) {
                this.c3Suit = Integer.parseInt(p);
            } else if (i == 6) {
                this.c4Value = Integer.parseInt(p);
            } else if (i == 7) {
                this.c4Suit = Integer.parseInt(p);
            } else if (i == 8) {
                this.c5Value = Integer.parseInt(p);
            } else if (i == 9) {
                this.c5Suit = Integer.parseInt(p);
            }
        }
    }


    public String toString()
    {
        String cardOne = "" + getValue(this.c1Value) + " of " + getSuit(this.c1Suit);
        String cardTwo = "" + getValue(this.c2Value) + " of " + getSuit(this.c2Suit);
        String cardThree = "" + getValue(this.c3Value) + " of " + getSuit(this.c3Suit);
        String cardFour = "" + getValue(this.c4Value) + " of " + getSuit(this.c4Suit);
        String cardFive = "" + getValue(this.c5Value) + " of " + getSuit(this.c5Suit);

        String answer = cardOne + ", " + cardTwo + ", " + cardThree + ", " + cardFour + ", " + cardFive;

        return answer;
    }


    public String status() // return "straight flush", "straight", "flush", or "none" //@TODO - STRAIGHT flush if Ace is high
    {
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        valueList.add(this.c1Value);
        valueList.add(this.c2Value);
        valueList.add(this.c3Value);
        valueList.add(this.c4Value);
        valueList.add(this.c5Value);
        Collections.sort( valueList );
        int straightDifH1H5 = valueList.get(4) - valueList.get(0);
        int straightDifH1H2 = valueList.get(1) - valueList.get(0);
        int straightDifH2H3 = valueList.get(2) - valueList.get(1);
        int straightDifH3H4 = valueList.get(3) - valueList.get(2);
        int straightDifH4H5 = valueList.get(4) - valueList.get(3);
        String answer = "none";
        ArrayList <Integer> aceHigh = new ArrayList<Integer>();
        aceHigh.add(1);
        aceHigh.add(10);
        aceHigh.add(11);
        aceHigh.add(12);
        aceHigh.add(13);

        HashSet <Integer> flushCheck = new HashSet<Integer>();
        flushCheck.add(this.c1Suit);
        flushCheck.add(this.c2Suit);
        flushCheck.add(this.c3Suit);
        flushCheck.add(this.c4Suit);
        flushCheck.add(this.c5Suit);

        HashSet<Integer> straightCheck = new HashSet<Integer>();
        straightCheck.add(straightDifH1H2);
        straightCheck.add(straightDifH2H3);
        straightCheck.add(straightDifH3H4);
        straightCheck.add(straightDifH4H5);

        if (valueList.containsAll(aceHigh)) {
            answer = "straight";
        }
        if (straightCheck.size() == 1 && straightCheck.contains(1)) { //@TODO - Logic doesnt work
            answer = "straight";
        }
        if (flushCheck.size() == 1 ) {
            if (answer.equals("straight")) {
                answer = "straight flush";
            } else {
                answer = "flush";
            }
        }
        return answer;
    }



    public static void main(String[] args) {
//        // sample testing code
//        Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );
//        System.out.println( h.toString() );
//        System.out.println( h.status() );
    }
    
}

