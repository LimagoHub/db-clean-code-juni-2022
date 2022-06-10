package services;

import models.Candidate;
import models.Fahrplan;
import processors.ItemProcessor;

public class DemoService {

    private final ItemProcessor<Fahrplan,Candidate> itemProcessor;

    public DemoService(ItemProcessor<Fahrplan,Candidate> itemProcessor) {
        this.itemProcessor = itemProcessor;
    }

    public void serviceCall(/* Parameterobject */)throws Exception {
        Candidate candidate = itemProcessor.process(new Fahrplan());
        System.out.println(candidate);
    }
}
