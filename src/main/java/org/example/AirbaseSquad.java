package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirbaseSquad {


    public int getNumberOfSquads(List<List<Integer>> squadList){
        int rows = squadList.size();
        int columns = squadList.get(0).size();
        int group[][] = new int[rows][columns];

        boolean[][] visited = new boolean[rows][columns];

        for(int i = 0;i< rows ;i++){
            for(int j =0;j<columns;j++){
               visited[i][j] = false;
                }
            }
        int count = 0;
        int groupNumber = 1;

        for(int i = 0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(visited[i][j] == false && squadList.get(i).get(j)==1){
                    count++;
                    group[i][j] = groupNumber;
                    DFS(squadList, i, j, visited, groupNumber, group);
                    groupNumber++;
                }
            }
        }
        System.out.println(isConnected(1,1,4,3, group));
        return count;
    }



    public void DFS(List<List<Integer>> squadList, int row, int column, boolean[][] visited, int groupNumber, int[][] group){

        visited[row][column] = true;

        int n = squadList.size();
        int m = squadList.get(0).size();

        int delrow[] = {-1,0,1,0};
        int delColumn[] = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow= row+delrow[i];
            int ncol = column +delColumn[i];
            if(nrow >= 0  && nrow < n && ncol >= 0 && ncol < m
                    && visited[nrow][ncol] == false && squadList.get(nrow).get(ncol) == 1)
            {
                group[nrow][ncol] = groupNumber;
                DFS(squadList, nrow, ncol, visited, groupNumber, group);
            }
        }
    }

    public boolean isConnected(int X1, int X2, int Y1, int Y2, int group[][]){
        if(group[X1][Y1]==group[X2][Y2]){
            return true;
        }
        return false;
    }
    public static void main(String[] args){

        List<Integer> row1= Arrays.asList(1,1,1,1,0);
        List<Integer> row2= Arrays.asList(1,1,0,1,0);
        List<Integer> row3= Arrays.asList(1,1,0,0,0);
        List<Integer> row4= Arrays.asList(0,0,0,1,1);

        List<List<Integer>> listOfList = new ArrayList<>();
        listOfList.add(row1);
        listOfList.add(row2);
        listOfList.add(row3);
        listOfList.add(row4);
        AirbaseSquad airbase = new AirbaseSquad();
        System.out.println(airbase.getNumberOfSquads(listOfList));
      //  System.out.println(airbase.isConnected(0,1,1,0));



//    ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]

    }
}
