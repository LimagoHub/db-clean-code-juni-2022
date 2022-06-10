package de.db.games;

import de.db.games.players.Player;
import de.db.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractRoundBasedGame<BOARD,MOVE> implements Game{

    private final List<Player<BOARD,MOVE>> players = new ArrayList<>();
    private BOARD board;

    private MOVE move;

    private Player<BOARD,MOVE> currentPlayer;

    private final Writer writer;

    public AbstractRoundBasedGame(Writer writer) {
        this.writer = writer;
    }

    protected Player<BOARD,MOVE> getCurrentPlayer() {
        return currentPlayer;
    }

    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(BOARD board) {
        this.board = board;
    }

    protected MOVE getMove() {
        return move;
    }

    protected void setMove(MOVE move) {
        this.move = move;
    }

    protected List<Player<BOARD, MOVE>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    private void setCurrentPlayer(Player<BOARD,MOVE> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public void addPlayer(Player<BOARD,MOVE> player) {
        players.add(player);
    }

    public void removePlayer(Player<BOARD,MOVE> player) {
        players.remove(player);
    }
    @Override
    public void play() {
        while (! isGameover())  executeRounds();

    }

    private void executeRounds() { // Integration
        for(Player<BOARD,MOVE> player : players)  executeTurnForPlayer(player);


    }

    private void executeTurnForPlayer(Player<BOARD,MOVE> player) {
        if(isGameover()) return;
        setCurrentPlayer(player);
        executeTurnForCurrentPlayer();
    }

    private void executeTurnForCurrentPlayer() { // Integration
        initTurn();
        invokeCurrentPlayerTurn();
        terminateTurn( );
    }


    protected void initTurn() {
        // Empty hook
    }
    private void invokeCurrentPlayerTurn() {
        do {
            move = getCurrentPlayer().doTurn(board);
        } while(playersTurnIsInvalid());

    }

    private boolean playersTurnIsInvalid() {
        if(isTurnValid()) return false;
        write("Ungültiger zug");
        return true;
    }

    private void terminateTurn() {
        updateBoard();
        writeGameOverMessageIfGameIsOver();
    }

    private void writeGameOverMessageIfGameIsOver() {
        if(isGameover()) write(String.format("%s hat verloren", getCurrentPlayer().getName()));

    }

    protected void write(String message) {
        writer.write(message);
    }
    protected abstract boolean isGameover();
    protected abstract boolean isTurnValid();
    protected abstract void updateBoard();


}
