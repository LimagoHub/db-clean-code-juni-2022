package de.db.games.nim.player;

import java.util.Random;

public class OmaPlayer extends AbstractNimGamePlayer{

    private final Random random = new Random();
    public OmaPlayer() {
    }

    public OmaPlayer(String name) {
        super(name);
    }

    @Override
    public Integer doTurn(Integer integer) {
        int move = random.nextInt(5);
        write(String.format("%s nimmt %s Steine.", getName(), move));
        return move;
    }
}
