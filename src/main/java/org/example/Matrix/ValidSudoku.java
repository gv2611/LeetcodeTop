package org.example.Matrix;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        if (allRowsUnique(board) && allColumnsUnique(board) && eachBoxUnique(board)) {
            return true;
        }
        return false;
    }

    private boolean allRowsUnique(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!hs.contains(board[i][j])) {
                        hs.add(board[i][j]);
                    }
                    else if (hs.contains(board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean allColumnsUnique(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    if (!hs.contains(board[j][i])) {
                        hs.add(board[j][i]);
                    }
                    else if (hs.contains(board[j][i])){
                        return false;
                    }
                }
            }
        }
        return true;

    }


    private boolean eachBoxUnique(char[][] board) {
        for(int i=0; i<board.length; i+=3){
            for (int j =0; j<board[0].length;j+=3){
                if(!isBoxValid(i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBoxValid(int row, int column, char[][] board) {
        int limitI = row+3;
        int limitJ = column+3;
        HashSet<Character> hs = new HashSet<>();

        for(int i = row; i< limitI; i++){
            for(int j = column; j< limitJ; j++){
                if(board[i][j]!='.') {
                    if (!hs.contains(board[i][j])) {
                        hs.add(board[i][j]);
                    } else if (hs.contains(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidSudoku valid = new ValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(valid.isValidSudoku(board));
    }
}
