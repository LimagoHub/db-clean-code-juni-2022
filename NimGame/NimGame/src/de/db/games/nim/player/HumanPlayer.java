package de.db.games.nim.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractNimGamePlayer{

    private final Scanner scanner = new Scanner(System.in);// Kröte
    public HumanPlayer() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }

    public HumanPlayer(String name) {
        super(name);
    }

    /**
     *
     * @param stones bnxvbncvn
     * @return vcxncvn
     */
    @Override
    public Integer doTurn(Integer stones) {
        write(String.format("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3.", stones));// noch eine Kröte
        return  scanner.nextInt();
    }
}
