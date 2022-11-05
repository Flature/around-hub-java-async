package studio.aroundhub.racecondition;

public class CounterWorker2 extends Thread{
    public void run() {
        for(int i = 0 ; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " >> minus");
            int temp = --Shared.counter;
            System.out.println(Thread.currentThread().getName() + " >> minus : " + temp);
        }
    }
}
