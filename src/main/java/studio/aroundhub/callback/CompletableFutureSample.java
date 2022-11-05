package studio.aroundhub.callback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample {

    public CompletableFutureSample() {
        new Thread(() -> {
            try {
                CompletableFuture.supplyAsync(this::work1)
                        .thenAccept(this::work2)
                        .get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        work3();
    }

    private String work1() {
        System.out.println(Thread.currentThread().getName() + " >> job 1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " >> job 1 done");
        return "Flature";
    }

    private void work2(String result) {
        System.out.println(Thread.currentThread().getName() + " >> job 1 result : " + result);
        System.out.println(Thread.currentThread().getName() + " >> job 2 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " >> job 2 done");
    }

    private void work3() {
        System.out.println(Thread.currentThread().getName() + " >> job 3 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " >> job 3 done");
    }
}
