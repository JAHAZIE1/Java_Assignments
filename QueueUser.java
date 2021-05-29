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
