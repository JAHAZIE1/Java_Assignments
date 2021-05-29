// 13193920
// jahazi01@student.bbk.ac.uk

// Response to Q1:
// This update will continue to allow the program to be completed.
// The total number of pop is still below the total number of push.

// Response to Q2:
// This will update will stop the program from being completed.
// Once all the 16 pushs are completed and the ArrayList is empty
// the pop will be stuck on wait() and never finish. Unless all the pops can finish before the pushs
// are completed which is unlikely as the pop is more then the total pushes.

// Response to Q3:
// The program will be stuck. If an empty arraylist passes through pop that thread will wait.
// Without the notifyall() in the push there is nothing to update pop to stop waiting.

class Pusher implements Runnable
{
    BoundedQueue answerlist;
    String answerString;
    int noOfTimes;

    Pusher( BoundedQueue q, String name, int iterations )
    {
       this.answerlist = q;
       this.answerString = name;
       this.noOfTimes = iterations;
 
    }
    public void run()
    {
        for (int i = 1 ; i <= this.noOfTimes ; i++) {
            this.answerlist.push(this.answerString);
        }

    }
}

class Popper implements Runnable
{
    BoundedQueue popperList;
    int popperIteration;

    Popper( BoundedQueue q, int iterations )
    {
        this.popperList = q;
        this.popperIteration = iterations;
    }
    public void run()
    {
        for (int i = 1 ; i <= this.popperIteration ; i++) {
            this.popperList.pop();
        }
    }
}

public class QueueUser {
    public static void main(String[] args) {

        BoundedQueue testCase = new BoundedQueue(2);
        Pusher pushCaseA = new Pusher(testCase, "a", 8);
        Pusher pushCaseB = new Pusher(testCase, "b", 8);
        Popper popCase = new Popper(testCase, 16);
        Thread pushA = new Thread(pushCaseA);
        Thread pushB = new Thread(pushCaseB);
        Thread pop = new Thread(popCase);
        pushA.start();
        pushB.start();
        pop.start();

    }
}
