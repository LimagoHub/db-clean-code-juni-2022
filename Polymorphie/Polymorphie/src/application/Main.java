package application;

import math.Calculator;
import math.CalculatorImpl;
import math.CalculatorLogger;
import math.CalculatorSecure;

import java.awt.*;
import java.awt.event.MouseListener;

public class Main  {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        calculator = new CalculatorLogger(calculator);
        calculator = new CalculatorSecure(calculator);
        CalculatorClient client = new CalculatorClient(calculator);
        client.go();
    }
}
