package studio.aroundhub.racecondition;

public class Worker3 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++){
            synchronized (Shared.blockingQueue){
                System.out.println(Thread.currentThread().getName() + " >> add");
                Shared.blockingQueue.add(i);
                System.out.println(Thread.currentThread().getName() + " >> add : " + i);
            }
        }
    }
}
