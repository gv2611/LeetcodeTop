package org.example.Matrix;
//
//Any live cell with fewer than two live neighbors dies as if caused by under-population.
//        Any live cell with two or three live neighbors lives on to the next generation.
//        Any live cell with more than three live neighbors dies, as if by over-population.
//        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

import java.util.ArrayList;

class cellDetails {
    int i, j;
    boolean isAlive;

    cellDetails(int i, int j, boolean isAlive) {
        this.j = j;
        this.i = i;
        this.isAlive = isAlive;
    }
}

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int column[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        ArrayList<cellDetails> cellDet = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (checkNeighbourAlive(i, j, row, column, board) < 2) {
                        cellDet.add(new cellDetails(i, j, false));
                    }
                    if (checkNeighbourAlive(i, j, row, column, board) == 2 || checkNeighbourAlive(i, j, row, column, board) == 3) {
                        cellDet.add(new cellDetails(i, j, true));
                    }
                    if (checkNeighbourAlive(i, j, row, column, board) > 3) {
                        cellDet.add(new cellDetails(i, j, false));
                    }
                } else if (board[i][j] == 0) {

                    if (checkNeighbourAlive(i, j, row, column, board) == 3) {
                        cellDet.add(new cellDetails(i, j, true));
                    }
                }
            }
        }

        for(cellDetails eachCell : cellDet){
            if( eachCell.isAlive == true){
                board[eachCell.i][eachCell.j] = 1;
            }
            else if (eachCell.isAlive == false){
                board[eachCell.i][eachCell.j] = 0;
            }
        }
        print2DArray(board);
    }

    private int checkNeighbourAlive(int i, int j, int[] row, int[] column, int[][] board) {
        int countOnes = 0;

        for (int k = 0; k < row.length; k++) {
            int newRow = i + row[k];
            int newCol = j + column[k];
            if (newRow>=0 && newRow< board.length && newCol>=0 && newCol< board[0].length && board[newRow][newCol] == 1) {
                countOnes++;
            }
        }
        return countOnes;
    }

    private int checkNeighbourDead(int i, int j, int[] row, int[] column, int[][] board) {
        int countZeroes = 0;

        for (int k = 0; k < row.length; k++) {
            int newRow = i + row[k];
            int newCol = j + column[k];
            if (board[newRow][newCol] == 0) {
                countZeroes++;
            }
        }
        return countZeroes;
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife.gameOfLife(matrix);
    }

}
