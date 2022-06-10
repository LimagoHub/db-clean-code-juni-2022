package main;

import client.CalcClient;
import de.db.math.Calculator;
import de.db.math.CalculatorImpl;
import de.db.math.CalculatorLogger;
import de.db.math.CalculatorSecure;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        calculator = new CalculatorLogger(calculator);
        //calculator = new CalculatorSecure(calculator);
        CalcClient client = new CalcClient(calculator);
        client.doWorkWithCalculator();
    }
}
