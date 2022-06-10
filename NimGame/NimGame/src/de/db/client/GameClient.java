package de.db.client;

import de.db.games.Game;

public class GameClient {

    private final Game game;

    public GameClient(Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}
