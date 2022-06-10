package de.db.games.nim.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final int [] moves = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Integer doTurn(Integer stones) {
        int move = moves[stones % 4];
        write(String.format("Computer nimmt %s Steine.", move));
        return move;
    }
}
