// 13193920
// jahazi01@student.bbk.ac.uk

import java.io.*;
import java.util.*;

public class BoundedQueue {

    int maxSize = 0;
    ArrayList<String> answerList = new ArrayList<String>();
    int pushCount = 1;
    int popcount = 1;



    BoundedQueue(int maxsize) {
        this.maxSize = maxsize;

    }

    public synchronized void push(String s) {

        try {
            while(this.answerList.size() > this.maxSize) {
                wait();

            }
                this.answerList.add(s);
                System.out.println("Pushed: " + this.pushCount + " " + s + " / " + this.answerList.size());
                notifyAll();
                this.pushCount++;

        } catch (InterruptedException e) {
        }


    }

    public synchronized String pop() {
        try {
            while (this.answerList.size() == 0) {
                wait();

            }
                String removedWord = this.answerList.remove(0);
                System.out.println("Popped: " + this.popcount + " " + removedWord + " / " + this.answerList.size());
                this.popcount++;
                notifyAll();

            return null;
        } catch (InterruptedException e) {

        }


        return null;


    }
}



