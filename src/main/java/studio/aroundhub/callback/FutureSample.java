package studio.aroundhub.callback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {

    public FutureSample() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " >> job 1 start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " >> job 1 done");
            return "Flature";
        });

        System.out.println(Thread.currentThread().getName() + " >> job 2 start");
        String text = "";
        try {
            System.out.println(Thread.currentThread().getName() + " >> job 1 check : " + future.isDone()); // isDone() : 작업 완료 체크 (non-blocking)
            text = future.get(); // get() : 작업이 완료될 때까지 블로킹 대기
            System.out.println(Thread.currentThread().getName() + " >> job 1 check : " + future.isDone());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " >> job 1 done : " + text);
        System.out.println(Thread.currentThread().getName() + " >> job 2 done");
    }

}
