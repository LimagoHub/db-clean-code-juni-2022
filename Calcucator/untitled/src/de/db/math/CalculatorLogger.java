package de.db.math;

public class CalculatorLogger implements Calculator{

    private final Calculator calculator;

    public CalculatorLogger(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double add(double a, double b) {
        System.out.println("Add wurde gerufen");
        return calculator.add(a, b);
    }
}
