import java.util.*;

interface PredicateStringPair
{
    boolean better( String a, String b );
}


public class CustomStringSort {

    public static Comparator<String> createComparator( PredicateStringPair pred ) {

            PredicateStringPair finalPred = pred;
            Comparator<String> answer = (o1, o2) -> {
                if (finalPred.better(o1, o2)) {
                    return -1;
                } else if (finalPred.better(o2, o1)) {
                    return 1;
                } else {
                    return 0;
                }
            };

        return answer;
        }

    public static void sortStrings( ArrayList<String> lst, PredicateStringPair pred )
    {
        Comparator<String> comparable = createComparator(pred);
        Collections.sort(lst, comparable);
    }

    public static void sortStringsLonger( ArrayList<String> lst )
    {
        PredicateStringPair betterLonger;
        betterLonger = (a,b) -> {
            if (a.length() > b.length()) {
                return true;
            } else return false;
        };
        sortStrings(lst, betterLonger);
    }

    public static void sortStringsNumAs( ArrayList<String> lst )
    {
        PredicateStringPair betterNum;
        betterNum = (a,b) -> {
            int totalA = 0;
            int totalB = 0;

            for (int i = 0; i < a.length(); i++) { // iterate through each character in string a
                char currentLetterA = a.charAt(i);
                if (currentLetterA == 'a' | currentLetterA == 'A') { // count total number of 'a'/'A'.
                    totalA++;
                }
            }

            for (int z = 0; z < b.length(); z++) { //iterate through each character in string a
                char currentLetterB = b.charAt(z);
                if (currentLetterB == 'a' | currentLetterB == 'A') { // count total number of 'a'/'A'.
                    totalB++;
                }
            }

            if (totalA > totalB) { // compare total number of 'a'/'A'
                return true;
            } else return false;
        };
        sortStrings(lst, betterNum);

    }

    public static void sortStringsDictionary( ArrayList<String> lst )
    {
        PredicateStringPair betterDic;
        betterDic = (a, b) -> {

            char currentLetterA;
            char currentLetterB;
            int maxLengthCheck=0;
            ArrayList<Character> alphabetList = new ArrayList<Character>();

            for (char l = 'a'; l<= 'z'; l++) { // an array to contain both lower and upper case in right order for comparison later
                char lowerCaseLetter = l;
                char upperCaseLetter = Character.toUpperCase(l);

                alphabetList.add(lowerCaseLetter);
                alphabetList.add(upperCaseLetter);
            }


            if (a.length() < b.length()) {
                maxLengthCheck = a.length();
            } else {
                maxLengthCheck = b.length();
            }

            for (int z = 0; z < maxLengthCheck; z++) {
                currentLetterA = a.charAt(z);
                currentLetterB = b.charAt(z);

                if (Character.compare(currentLetterA, currentLetterB) == 0 ) { // character the exact same. break and move to next letter. left blank so can restart for loop
                } else if (!Character.isLetter(currentLetterB) & Character.isLetter(currentLetterA)) { // if index at string b is not a letter but index at string a is
                    return true;
                } else if (!Character.isLetter(currentLetterA) & Character.isLetter(currentLetterB)) { //if index at string a is not a letter but index at string b is
                    return false;
                } else if (Character.isLetter(currentLetterA) && Character.isLetter(currentLetterB)) { // if both characters are letters
                    int indexLetterA = alphabetList.indexOf(currentLetterA);
                    int indexLetterB = alphabetList.indexOf(currentLetterB);

                    if (indexLetterA < indexLetterB) { // using arraylist to compare index of letter
                        return true;
                    } else return false;

                } else if (!Character.isLetter(currentLetterA) & !Character.isLetter(currentLetterB)) { //if both characters are not letters
                    int compareValue = Character.compare(currentLetterA, currentLetterB);
                    if (compareValue < 0) { // comparing char value of non letter characters
                        return true;
                    } else {
                        return false;
                    }

                }

            }

            if (a.length() < b.length()) {//all characters the same above and now assessing length of each string
                return true;
            } else return false;


        };

        sortStrings(lst, betterDic);
   
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
        sortStringsLonger( fruits ); // removed longer
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
