package studio.aroundhub.racecondition;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Shared {
    public static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    public static Integer counter = 0;
}
