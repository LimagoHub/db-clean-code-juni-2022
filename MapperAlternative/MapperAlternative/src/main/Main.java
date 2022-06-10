package main;

import models.Candidate;
import models.Fahrplan;
import processors.CompositeItemProcessor;
import processors.DataEnrichProcess;
import processors.ValidierungsProcess;
import services.DemoService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        ValidierungsProcess vp = new ValidierungsProcess();
        DataEnrichProcess dep = new DataEnrichProcess();
        CompositeItemProcessor<Fahrplan, Candidate> compositeItemProcessor = new CompositeItemProcessor<>();
        compositeItemProcessor.setDelegates(Arrays.asList(vp,dep));

        DemoService service = new DemoService(compositeItemProcessor);
        service.serviceCall();
    }
}
