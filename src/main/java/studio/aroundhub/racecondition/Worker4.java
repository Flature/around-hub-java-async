package studio.aroundhub.racecondition;

public class Worker4 extends Thread{
    public void run(){
        int it = -1;
        while(it < 99){
            if(Shared.blockingQueue.isEmpty()){
                continue;
            }
            synchronized (Shared.blockingQueue){
                System.out.println(Thread.currentThread().getName() + " >> del");
                it = Shared.blockingQueue.poll();
                System.out.println(Thread.currentThread().getName() + " >> del : " + it);
            }
        }
    }
}
