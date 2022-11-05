package studio.aroundhub.racecondition;

public class RaceConditionSample {

    public RaceConditionSample() {
        /*
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();
        worker1.start();
        worker2.start();
         */
        /*
        Worker3 worker3 = new Worker3();
        Worker4 worker4 = new Worker4();
        worker3.start();
        worker4.start();
         */

        CounterWorker1 counterWorker1 = new CounterWorker1();
        CounterWorker2 counterWorker2 = new CounterWorker2();
        counterWorker1.start();
        counterWorker2.start();

        /*
        CounterWorker3 counterWorker3 = new CounterWorker3();
        CounterWorker4 counterWorker4 = new CounterWorker4();
        counterWorker3.start();
        counterWorker4.start();
         */
    }

}
