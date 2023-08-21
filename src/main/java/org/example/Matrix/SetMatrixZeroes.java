package org.example.Matrix;

import java.util.HashSet;

class Pair{
    private int row;
    private int column;
    Pair(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        HashSet<Pair> pairs = new HashSet<>();

        for(int i = 0 ;i<matrix.length;i++){
            for(int j= 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    pairs.add(new Pair(i, j));
                    //    matrix = setZeroForIndex(i, j, matrix);
                }
            }
        }

        for(Pair pair : pairs){
            matrix = setZeroForIndex(pair.getRow(), pair.getColumn(), matrix);
        }
        print2DArray(matrix);
    }

    private int[][] setZeroForIndex(int i, int j, int[][] matrix) {
        int row = 0;
        int column = 0;

        while(row < matrix.length){
            matrix[row][j] = 0;
            row++;
        }
        while(column < matrix[0].length){
            matrix[i][column] = 0;
            column++;
        }
        return matrix;
    }
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        SetMatrixZeroes set = new SetMatrixZeroes();
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int [][] matrix2  = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        set.setZeroes(matrix2);
    }
}
