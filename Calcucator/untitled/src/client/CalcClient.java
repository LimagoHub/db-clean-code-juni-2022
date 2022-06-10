package client;

import de.db.math.Calculator;

public class CalcClient {

    private final Calculator calculator;

    public CalcClient(Calculator calculator) {
        this.calculator = calculator;
    }

    public void doWorkWithCalculator( ) {
        System.out.println(calculator.add(3,4));
    }
}
