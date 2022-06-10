package de.db.games.nim;

import de.db.games.AbstractRoundBasedGame;
import de.db.io.Writer;

public class NimGameImpl extends AbstractRoundBasedGame<Integer,Integer> {



    public NimGameImpl(final Writer writer) {
        super(writer);
        setBoard(23);

    }


    protected boolean isTurnValid() {
        return getMove() >= 1 && getMove() <= 3;
    }
    protected void updateBoard() {
        setBoard(getBoard()-getMove());
    }

    protected boolean isGameover() {
        return getBoard() < 1 || getPlayers().isEmpty();
   }

    @Override
    protected void initTurn() {
        write(getCurrentPlayer().getName() + " ist am Zug!");
    }
}
