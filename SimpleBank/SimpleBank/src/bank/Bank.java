package bank;

public class Bank {
    private int [] konten = {20, 50, 100};

    public void kontoStand() {
        for (int i = 0; i < konten.length; i++) {
            System.out.println(String.format("Konto Nr. %s hat den Saldo %s.", i, konten[i]));
        }
        System.out.println("--------------------");
    }

    public synchronized void ueberweisen(int von, int nach, int betrag) throws Exception{


                int zettel = konten[von];
                zettel -= betrag;
                Thread.sleep((long) (Math.random() * 1000));
                konten[von] = zettel;
                konten[nach] += betrag;
                kontoStand();

    }
}
