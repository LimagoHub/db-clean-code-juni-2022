package application;

import math.Calculator;


public class CalculatorClient {


    private final Calculator calculator;

    public CalculatorClient(Calculator calculator) {
        this.calculator = calculator;
    }

    public void go() {


        System.out.println(calculator.add(3,4));

    }
}
