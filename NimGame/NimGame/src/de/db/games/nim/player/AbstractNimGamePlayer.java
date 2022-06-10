package de.db.games.nim.player;

import de.db.games.players.AbstractPlayer;

public abstract class AbstractNimGamePlayer extends AbstractPlayer<Integer,Integer> {

    protected AbstractNimGamePlayer() {
    }

    protected AbstractNimGamePlayer(String name) {
        super(name);
    }
}
