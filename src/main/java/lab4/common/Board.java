package lab4.common;

public class Board {

    private final int[][] grid = new int[19][19];

    public synchronized boolean placeMove(Move m) {
        if (m.x < 0 || m.x >= 19 || m.y < 0 || m.y >= 19) return false;
        if (grid[m.x][m.y] != 0) return false;

        grid[m.x][m.y] = m.player;
        return true;
    }
}