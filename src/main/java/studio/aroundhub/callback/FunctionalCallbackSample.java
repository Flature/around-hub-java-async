package studio.aroundhub.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class FunctionalCallbackSample {

    private static ExecutorService executorService;

    public FunctionalCallbackSample() {
        executorService = Executors.newCachedThreadPool();

        execute(parameter -> {
            System.out.println(Thread.currentThread().getName() + " >> parameter : " + parameter);
            System.out.println(Thread.currentThread().getName() + " >> JOB STARTED!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " >> JOB DONE!");
        });

        System.out.println(Thread.currentThread().getName() + " >> X JOB STARTED!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " >> X JOB DONE!");
    }

    /*
    Runnable : 인자와 리턴갑싱 모두 없음
    Supplier<R>, Callable<R> : 인자는 없고, R 타입의 객체를 리턴
    Consumer<T> : T 타입의 인자를 받고, 아무것도 리턴하지 않음
    Function<T, R> : T 타입의 인자를 받고, R 타입의 객체를 리턴
     */
    public static void execute(Consumer<String> callback){
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " >> job started!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            String text = "Flature";
            System.out.println(Thread.currentThread().getName() + " >> job done!");

            callback.accept(text);
        });
    }

}
