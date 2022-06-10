package main;

import bank.Angestellter;
import bank.Bank;

import java.util.List;

public class Main {

    public static void main(String[] args)  throws Exception{
        Bank bank = new Bank();
        Angestellter [] mitarbeiter = {
                new Angestellter(bank, 0, 1, 20),
                new Angestellter(bank, 1, 2, 20),
                new Angestellter(bank, 2, 0, 20)
        };

        System.out.println("Vorher:");
        bank.kontoStand();

        for (int i = 0; i < mitarbeiter.length; i++) {
            mitarbeiter[i].start();
        }
    }
}
