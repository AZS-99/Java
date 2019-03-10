package game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Board {
    final int COMPLETE_TOUR_STEPS = 64;
    final int FRAME_LENGTH = 12;
    int positionY, positionX;
    int board[][];
    private final static int[][] moves = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

    public Board() {

        board = new int[FRAME_LENGTH][FRAME_LENGTH];
        for(int i = 0; i < FRAME_LENGTH; ++i) {
            for (int j = 0; j < FRAME_LENGTH; ++j) {
                if (i < 2 || j < 2 || i > FRAME_LENGTH - 3 || j > FRAME_LENGTH - 3)
                    board[i][j] = -1;
                else
                    board[i][j] = 0;
            }
        }

        Random random = new Random();
        positionY = random.nextInt(FRAME_LENGTH - 4) + 2;
        positionX = random.nextInt(FRAME_LENGTH - 4) + 2;

        board[positionY][positionX] = 1;
        solve(positionY, positionX, 1);
    }


    @Override
    public String toString() {
        String str = new String();
        for(int i = 0; i < FRAME_LENGTH; ++i) {
            for (int j = 0; j < FRAME_LENGTH; ++j) {
                str += board[i][j] + "\t";
            }
            str += '\n';
        }
        return str;
    }

    int getPositionY() {
        return positionY;
    }

    int getPositionX() {
        return positionX;
    }


     boolean solve(int column, int row, int count) {
        if (count == COMPLETE_TOUR_STEPS)
            return  true;


        ArrayList<int[]> neighbours = getNeighbours(column, row);
        if (neighbours.size() == 0)
            return false;

        Collections.sort(neighbours, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (var neighbour : neighbours) {
            board[neighbour[0]][neighbour[1]] = count + 1;
            if (solve(neighbour[0], neighbour[1], count + 1))
                return true;
            board[neighbour[0]][neighbour[1]] = 0;
        }


//        if (board[column + 2][row + 1] == 0) {
//            board[column + 2][row + 1] = count + 1;
//            if (solve(column + 2, row + 1, count + 1))
//                return true;
//            board[column + 2][row + 1] = 0;
//        }
//
//        if (board[column + 1][row + 2] == 0) {
//            board[column + 1][row + 2] = count + 1;
//            if (solve(column + 1, row + 2, count + 1))
//                return true;
//            board[column + 1][row + 2] = 0;
//        }
//
//        if (board[column - 1][row + 2] == 0) {
//            board[column - 1][row + 2] = count + 1;
//            if (solve(column - 1, row + 2, count + 1))
//                return true;
//            board[column - 1][row + 2] = 0;
//        }
//
//        if (board[column - 2][row + 1] == 0) {
//            board[column - 2][row + 1] = count + 1;
//            if (solve(column - 2, row + 1, count + 1))
//                return true;
//            board[column - 2][row + 1] = 0;
//        }
//
//
//        if (board[column - 2][row - 1] == 0) {
//            board[column - 2][row - 1] = count + 1;
//            if (solve(column - 2, row - 1, count + 1))
//                return true;
//            board[column - 2][row - 1] = 0;
//        }
//
//
//        if (board[column - 1][row - 2] == 0) {
//            board[column - 1][row - 2] = count + 1;
//            if (solve(column - 1, row - 2, count + 1))
//                return true;
//            board[column - 1][row - 2] = 0;
//        }
//
//        if (board[column + 1][row - 2] == 0) {
//            board[column + 1][row - 2] = count + 1;
//            if (solve(column + 1, row - 2, count + 1))
//                return true;
//            board[column + 1][row - 2] = 0;
//        }
//
//        if (board[column + 2][row - 1] == 0) {
//            board[column + 2][row - 1] = count + 1;
//            if (solve(column + 2, row - 1, count + 1))
//                return true;
//            board[column + 2][row - 1] = 0;
//        }

        return false;

    }


    private ArrayList<int[]> getNeighbours(int column, int row) {
        ArrayList<int[]> neighbours = new ArrayList<>();
        int x, y;
        for (var move : moves) {
            y = move[0];
            x = move[1];
            if (board[column + y][row + x] == 0)
                neighbours.add(new int[] {column + y, row + x, countNeighbours(column + y, row + x)});
        }
        return neighbours;
    }


    private int countNeighbours(int column, int row) {
        int total = 0;
        for (var move : moves)
            if ( board[column + move[0]][row + move[1]] == 0)
                ++total;
        return total;
    }
}