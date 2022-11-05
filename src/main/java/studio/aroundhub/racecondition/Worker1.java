package studio.aroundhub.racecondition;

public class Worker1 extends Thread{

    public void run() {
        for(int i = 0 ; i < 100; i++){
            Shared.blockingQueue.add(i);
            System.out.println(Thread.currentThread().getName() + " >> add : " + i);
        }
    }

}
