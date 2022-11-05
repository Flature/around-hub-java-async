package studio.aroundhub.racecondition;

public class CounterWorker1 extends Thread{
    public void run() {
        for(int i = 0 ; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " >> plus");
            int temp = ++Shared.counter;
            System.out.println(Thread.currentThread().getName() + " >> plus : " + temp);
        }
    }
}
