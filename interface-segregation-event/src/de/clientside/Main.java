package de.clientside;

import de.tiere.PigTooFatListener;
import de.tiere.Schwein;



public class Main {


	private Metzger metzger = new Metzger();
	private Spediteuer spediteuer = new Spediteuer();
	public static void main(String[] args) {
		new Main().run();

	}

	private void run() {
		Schwein piggy = new Schwein("Miss Piggy");
		piggy.addPigTooFatListener(s->spediteuer.fahren(s));
		piggy.addPigTooFatListener(new SchweineMetzgerAdapter());
		piggy.addPigTooFatListener(spediteuer::fahren);
		for (int i = 0; i < 11; i++) {
			piggy.fuettern();

		}

	}

	class SchweineMetzgerAdapter implements PigTooFatListener {

		@Override
		public void pigTooFat(Schwein dickesSchwein) {
			metzger.schlachten(dickesSchwein);
		}
	}

	class Metzger  {


		public void schlachten(Object dickesSchwein) {
			System.out.println("Messer wetz");
		}
	}

	class Spediteuer  {


		public void fahren(Object dickesSchwein) {
			System.out.println("wir fahren auf der Autobahn");
		}
	}

}



