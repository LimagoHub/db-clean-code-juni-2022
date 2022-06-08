package math;

public class CalculatorImpl implements ProfiCalculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return add(a, -b);
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }
}
