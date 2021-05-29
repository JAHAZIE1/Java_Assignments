// 13193920
// jahazi01@student.bbk.ac.uk

import java.io.*;
import java.util.*;

public class Roman {

    public static String convert( int num ) {
        String answer = "";

        int units = num%10;
        int tens = (num/10)%10;
        int hundreds = (num/100)%10;
        int thousands = (num/1000)%10;

        String [] UnitsArray = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String [] TensArray = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        String [] HundredsArray = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM","M"};
        String [] ThousandsArray = {"","M","MM","MMM"};

        answer = ThousandsArray[thousands] + HundredsArray[hundreds] + TensArray[tens] + UnitsArray[units];

        return answer;
    }

    public static void main(String[] args) {
 
    }

}