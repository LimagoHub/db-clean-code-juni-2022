package main;

import client.ArrayClient;
import common.BenchmarkProxy;
import field.FieldGenerator;
import field.inner.FieldGeneratorThreadedStrategy;
import number.inner.RandomNumberGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    //private final int [] feld = new int[Integer.MAX_VALUE >> 1];

    public static void main(String[] args) {

        new Main().go();

    }


    // 1. IntFeld erzeugen + feld füllen
    // 2. Zeitmessung (-> Instant)
     // 3. Zahlen erzeugen (IntNumberGenerator)

    private void go() {
        for(int threadCount = 1 ; threadCount <= Runtime.getRuntime().availableProcessors() + 1 ; threadCount ++) {
            startClient(threadCount);
        }

    }

    private void startClient(final int threadCount) {
        FieldGenerator fieldGenerator = createFieldGenerator(threadCount);
        ArrayClient client = createArrayClient(fieldGenerator);
        client.start();
    }

    private ArrayClient createArrayClient(FieldGenerator fieldGenerator) {
        ArrayClient client = new ArrayClient(fieldGenerator.createPopulatedFieldWithSize(Integer.MAX_VALUE /2));
        return client;
    }

    private FieldGenerator createFieldGenerator(int threadCount) {
        FieldGenerator fieldGenerator = new FieldGeneratorThreadedStrategy(threadCount, ()->new RandomNumberGenerator());
        fieldGenerator = (FieldGenerator) BenchmarkProxy.newInstance(fieldGenerator, millis->System.out.printf("Dauer mit %s Threads war %s millis.", threadCount, millis));
        return fieldGenerator;
    }
}
