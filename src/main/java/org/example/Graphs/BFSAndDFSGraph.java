package org.example.Graphs;


import java.util.*;

class Pair {
    private int row;
    private int column;

    Pair(int i, int j) {
        this.row = i;
        this.column = j;
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

    public String toString() {
        return "i=" + this.row + "j=" + this.column;
    }
}

public class BFSAndDFSGraph {

    public static void main(String[] args) {
        BFSAndDFSGraph bfs = new BFSAndDFSGraph();

        List<Integer> row1 = Arrays.asList(1, 1, 1, 1, 0);
        List<Integer> row2 = Arrays.asList(1, 1, 0, 1, 0);
        List<Integer> row3 = Arrays.asList(1, 1, 0, 1, 0);
        List<Integer> row4 = Arrays.asList(0, 0, 0, 1, 1);

        List<List<Integer>> listOfList = new ArrayList<>();
        listOfList.add(row1);
        listOfList.add(row2);
        listOfList.add(row3);
        listOfList.add(row4);

        // System.out.println(bfs.numberOfIslandsDfs(listOfList));
        System.out.println(bfs.numberOfIslandsBfs(listOfList));
    }

    private int numberOfIslandsBfs(List<List<Integer>> grid) {
        int rows = grid.size();
        int columns = grid.get(0).size();
        boolean visited[][] = new boolean[rows][columns];

        int component = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j] && grid.get(i).get(j) == 1) {
                    component++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return component;
    }

    private void bfs(List<List<Integer>> grid, boolean[][] visited, int row, int column) {
        Queue<Pair> queue = new LinkedList<>();
        int rows = grid.size();
        int columns = grid.get(0).size();

        queue.add(new Pair(row, column));
        int newRowIndex[] = {-1, 0, 1, 0};
        int newColumnIndex[] = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair visiting = queue.poll();
            visited[visiting.getRow()][visiting.getColumn()] = true;
            System.out.println("Visiting " + visiting.toString());

            for (int i = 0; i < 4; i++) {
                int newRow = visiting.getRow() + newRowIndex[i];
                int newColumn = visiting.getColumn() + newColumnIndex[i];
                boolean inBounds = newColumn < columns && newRow < rows && newColumn >= 0 && newRow >= 0;
                if (inBounds && grid.get(newRow).get(newColumn) == 1 && !visited[newRow][newColumn]) {
                    queue.add(new Pair(newRow, newColumn));
                }
            }
        }
    }

    private int numberOfIslandsDfs(List<List<Integer>> listOfList) {
        int row = listOfList.size();
        int column = listOfList.get(0).size();
        boolean visited[][] = new boolean[row][column];

        //left, up, right, bottom

        int components = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j] && listOfList.get(i).get(j) == 1) {
                    components++;
                    dfs(visited, listOfList, i, j);
                }
            }
        }
        return components;
    }

    private void dfs(boolean[][] visited, List<List<Integer>> listOfList, int row, int column) {

        visited[row][column] = true;
        int rowOfList = listOfList.size();
        int columnsOfList = listOfList.get(0).size();
        int newRowIndex[] = {-1, 0, 1, 0};
        int newColumnIndex[] = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + newRowIndex[i];
            int newColumn = column + newColumnIndex[i];
            if (newColumn < columnsOfList && newRow < rowOfList && newColumn >= 0 && newRow >= 0 && listOfList.get(newRow).get(newColumn) == 1 && !visited[newRow][newColumn]) {
                dfs(visited, listOfList, newRow, newColumn);
            }
        }
    }
}
