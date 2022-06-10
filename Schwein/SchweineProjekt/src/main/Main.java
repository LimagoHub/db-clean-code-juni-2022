package main;

import de.tiere.Schwein;

public class Main {

    public static void main(String[] args) {
        Schwein piggy = new Schwein("Miss Piggy");

        System.out.println(piggy);

        piggy.fressen();

        System.out.println(piggy);

        while(piggy.getGewicht() < 11) {

        }

        System.out.println(piggy);

    }
}
