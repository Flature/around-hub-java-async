package studio.aroundhub.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackSample {

    private static final CompletionHandler<String, Void> completionHandler
            = new CompletionHandler<>() {
        @Override
        public void completed(String result, Void attachment) {
            System.out.println(Thread.currentThread().getName() + " >> result : " + result);
            try {
                System.out.println(Thread.currentThread().getName() + " >> job started!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " >> job done!");
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
            System.out.println(Thread.currentThread().getName() + " >> 이전 작업 실패");
        }
    };

    public CallbackSample() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " >> JOB STARTED!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " >> JOB DONE!");

            String result = "Flature";
            if (result.equalsIgnoreCase("Flature")){
                completionHandler.completed(result, null);
            }else {
                completionHandler.failed(new IllegalStateException(), null);
            }
        });

        System.out.println(Thread.currentThread().getName() + " >> X Job Started!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " >> X Job Done!");
    }

}
