package studio.aroundhub.racecondition;

public class CounterWorker1 extends Thread{
    public void run() {
        for(int i = 0 ; i < 100; i++){
            int temp = ++Shared.counter;
            System.out.println(Thread.currentThread().getName() + " >> add : " + temp);
        }
    }
}
