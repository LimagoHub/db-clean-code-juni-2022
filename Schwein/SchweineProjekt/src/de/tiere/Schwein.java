package de.tiere;

public class Schwein {

    private String name;
    private volatile  int gewicht;

    public void fressen() {

        new Thread(this::fressenImpl).start();


    }

    private void fressenImpl() {
        try {
            Thread.sleep((long)(Math.random()* 2000));
            gewicht ++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Schwein() {
        this("nobody");
    }

    public Schwein(String name) {
        this.name = name;
        this.gewicht = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    private void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Schwein{");
        sb.append("name='").append(name).append('\'');
        sb.append(", gewicht=").append(gewicht);
        sb.append('}');
        return sb.toString();
    }
}
