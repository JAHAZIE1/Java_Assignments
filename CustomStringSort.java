// your_ID_here
// your_email_address_here

import java.io.*;
import java.util.*;


interface PredicateStringPair
{
    boolean better( String a, String b );
}


public class CustomStringSort {

    public static Comparator<String> createComparator( PredicateStringPair pred )
    {
        return null;
    }

    public static void sortStrings( ArrayList<String> lst, PredicateStringPair pred )
    {
 
    }

    public static void sortStringsLonger( ArrayList<String> lst )
    {
     
    }

    public static void sortStringsNumAs( ArrayList<String> lst )
    {
 
    }

    public static void sortStringsDictionary( ArrayList<String> lst )
    {
   
    }

  
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Strawberry");
        fruits.add("strawberries");
        fruits.add("Kiwi");
        fruits.add("kiwis");
        fruits.add("Banana");
        fruits.add("bananas");

        System.out.println( fruits );
        sortStringsLonger( fruits, longer );
        System.out.println( fruits );
        
        sortStringsNumAs( fruits );
        System.out.println( fruits );

        fruits.add( "@plum" );
        fruits.add( "@kumquat" );
        fruits.add( "banana" );
        fruits.add( "3 oranges" );
        fruits.add( "9 oranges" );
        fruits.add( "33 oranges" );
        System.out.println( fruits );
        sortStringsDictionary( fruits );
        System.out.println( fruits );
    }
}
