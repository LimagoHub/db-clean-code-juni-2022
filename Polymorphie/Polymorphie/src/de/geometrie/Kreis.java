package de.geometrie;

public class Kreis extends Punkt{

    private double radius;

    public Kreis() {
        this(0,0,0);
    }
    public Kreis(double radius) {
        this(0,0,radius);
    }

    public Kreis(double x, double y) {
        this(x,y,0);

    }
    public Kreis(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", Radius=" + radius;
    }
}
