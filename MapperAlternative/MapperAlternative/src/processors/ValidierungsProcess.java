package processors;

import models.Fahrplan;

public class ValidierungsProcess implements ItemProcessor<Fahrplan,Fahrplan> {
    @Override
    public Fahrplan process(Fahrplan item) throws Exception {
        // Validierung
        System.out.println("Es wird validiert und nix anderes");
        return item;
    }
}
