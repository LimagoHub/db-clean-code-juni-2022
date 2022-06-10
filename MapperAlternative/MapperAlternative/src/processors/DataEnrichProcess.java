package processors;

import models.Candidate;
import models.Fahrplan;

public class DataEnrichProcess implements ItemProcessor<Fahrplan, Candidate> {
    @Override
    public Candidate process(Fahrplan item) throws Exception {
        // Daten anreichern
        System.out.println("Daten anreichern");
        return new Candidate();
    }
}
