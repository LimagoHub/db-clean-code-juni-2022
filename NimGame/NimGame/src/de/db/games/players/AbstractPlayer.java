package de.db.games.players;

public abstract class AbstractPlayer<BOARD,MOVE> implements Player<BOARD,MOVE>{

    private String name = getClass().getSimpleName();

    protected AbstractPlayer() {

    }

    protected AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    protected void write(String message) {
        System.out.println(message);
    }
}
