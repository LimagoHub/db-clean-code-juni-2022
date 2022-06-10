package main;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception{
        new Main().go();
    }

    private void go() throws Exception{

        Instant start = Instant.now();

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        for(int i = 0; i < Runtime.getRuntime().availableProcessors() * 2; i++ )
//            service.execute(new MyRunnable());

        List<Future<Integer>> futures = new ArrayList<>();
        for(int i = 0; i < 5; i++ )
            futures.add(service.submit(new MyCallable()));



        service.shutdown();
        futures.forEach(c->{try {System.out.println(c.get());} catch(Exception e){}});
        //service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        Instant ende = Instant.now();
        System.out.println("Duration = " + Duration.between(start,ende).toMillis());
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                long value= (long) (Math.random()*2000);
                Thread.sleep(value);
                System.out.println(String.format("Thread Nr. %s terminiert mit Value %s", Thread.currentThread().getId(), value));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            long value= (long) (Math.random()*2000);
            Thread.sleep(value);
            return (int) value;
        }
    }
}
