package field.inner;

import field.FieldGenerator;
import number.NumberGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class FieldGeneratorThreadedStrategy extends AbstractFieldGenerator implements FieldGenerator { // Implements nessary for Dynamic Proxy

    private final int threadCount;
    private final Supplier<NumberGenerator> numberGeneratorFactory;

    private int segmentSize;
    private ExecutorService service;

    private int currentThreadNumber;



    public FieldGeneratorThreadedStrategy(int threadCount, Supplier<NumberGenerator> numberGeneratorFactory) {
        this.threadCount = threadCount;
        this.numberGeneratorFactory = numberGeneratorFactory;
    }

    @Override
    protected void fill() {
        try {
            fillParallel();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void fillParallel() throws InterruptedException {
        calulateSegmentSize();
        startParallelExcecutionWithThreadPool();
    }

    private void startParallelExcecutionWithThreadPool() throws InterruptedException {
        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        startAllWorkers();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startAllWorkers() {
        for(currentThreadNumber = 0; currentThreadNumber < threadCount; currentThreadNumber++) {
            startSingleWorker();
        }
    }

    private void startSingleWorker() {
        Segment segmentToFill = new Segment(currentThreadNumber, segmentSize);
        //service.execute(new FillSegmentWorker(segmentToFill));
        service.execute(new FillSegmentWorker(segmentToFill));
    }

    private void calulateSegmentSize() {
        segmentSize = getField().length / threadCount;
    }



    private class FillSegmentWorker implements Runnable {

        private final NumberGenerator numberGenerator = numberGeneratorFactory.get();
        private final Segment segment;

        public FillSegmentWorker(Segment segment) {
            this.segment = segment;
        }

        @Override
        public void run() {
            for(int i = segment.getStartIndex() ; i < segment.getEndeIndex(); i ++) {
                getField()[i] = numberGenerator.nextNumber();
            }
        }
    }

    private static class Segment {
        private final int startIndex;
        private final int segmentSize;

        public Segment(final int currentThreadNumber, final int segmentSize) {
            this.startIndex = currentThreadNumber * segmentSize;
            this.segmentSize = segmentSize;

        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndeIndex() {
            return startIndex + segmentSize;
        }

        public int getSegmentSize() {
            return segmentSize;
        }
    }
}
