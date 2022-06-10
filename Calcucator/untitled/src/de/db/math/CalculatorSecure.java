package de.db.math;

public class CalculatorSecure implements  Calculator{

    private final Calculator calculator;

    public CalculatorSecure(Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(double a, double b) {
        System.out.println("Du kommst hier rein");
        return calculator.add(a, b);
    }
}
