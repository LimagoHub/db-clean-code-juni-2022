package de.db.application;

import de.db.client.GameClient;
import de.db.games.AbstractRoundBasedGame;
import de.db.games.nim.NimGameImpl;
import de.db.games.nim.player.ComputerPlayer;
import de.db.games.nim.player.HumanPlayer;
import de.db.games.nim.player.OmaPlayer;
import de.db.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        AbstractRoundBasedGame<Integer,Integer> game = new NimGameImpl(new ConsoleWriter());

        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        game.addPlayer(new OmaPlayer("Oma"));

        GameClient client = new GameClient(game);

        client.go();
    }

}
