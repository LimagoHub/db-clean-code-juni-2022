package de.db.games.players;

public interface Player<BOARD,MOVE> {
    String getName();
    MOVE doTurn(final BOARD board);
}
