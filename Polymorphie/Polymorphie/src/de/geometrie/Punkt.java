package de.geometrie;

public class Punkt {

    private double x,y;

    public Punkt() {
        this(0,0);
    }
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void rechts() {
        x ++;
    }
    public void rechts(double offset) {
        x += offset;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName() + " ");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(' ');
        return sb.toString();
    }
}
