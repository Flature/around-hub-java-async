package studio.aroundhub.racecondition;

public class Worker2 extends Thread{

    public void run() {
        int it = -1;
        while(it < 99){
            if(Shared.blockingQueue.isEmpty()){
                continue;
            }
            it = Shared.blockingQueue.poll();
            System.out.println(Thread.currentThread().getName() + " >> poll : " + it);
        }
    }

}
