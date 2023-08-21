package org.example.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
            int rowEnd = matrix.length-1;
            int columnEnd = matrix[0].length-1;
            int rowStart =0;
            int columnStart = 0;
            int i = 0, j=0;
            List<Integer> list = new ArrayList<>();

            while(rowStart<=rowEnd && columnStart<=columnEnd){

                while(j <= columnEnd){
                    list.add (matrix [i][j]);
                    j++;
                }
                if(list.size() == matrix.length * matrix[0].length){
                    break;
                }
                j--;
                rowStart++;
                i++;

                while(i <= rowEnd){
                    list.add( matrix[i][j]);
                    i++;
                }
                if(list.size() == matrix.length * matrix[0].length){
                    break;
                }
                i--;
                columnEnd--;
                j--;

                while(j >= columnStart){
                    list.add(matrix[i][j]);
                    j--;
                }
                if(list.size() == matrix.length * matrix[0].length){
                    break;
                }
                j++;
                rowEnd--;
                i--;
                while(i>=rowStart){
                    list.add(matrix[i][j]);
                    i--;
                }
                if(list.size() == matrix.length * matrix[0].length){
                    break;
                }
                i++;
                columnStart++;
                j++;

            }
            return list;

    }

    public static void main(String [] args){
        SpiralMatrix spiral = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13,14,15,16},
                {17,18,19,20}
        };
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiral.spiralOrder(matrix2));
    }

}
