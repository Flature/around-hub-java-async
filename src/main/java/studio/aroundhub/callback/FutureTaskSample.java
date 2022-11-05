package studio.aroundhub.callback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskSample {

    public FutureTaskSample() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " >> job 1 start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " >> job 1 done");
            return "Flature";
        });

        executorService.submit(futureTask);

        String result = "";
        try {
            result = futureTask.get();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " >> job 1 result : " + result);
    }

}
