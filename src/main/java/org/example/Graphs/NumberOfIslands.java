//package org.example.Graphs;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//class Node1 {
//    private String value;
//    private int isVisited;
//
//    Node1(String value) {
//        this.value = value;
//        this.isVisited = 0;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public int getIsVisited() {
//        return isVisited;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public void setIsVisited(int isVisited) {
//        this.isVisited = isVisited;
//    }
//
//    public String toString() {
//        return "[" + this.value + "," + this.isVisited+ "] " ;
//    }
////    public String toString(Node1 node){
////        return node.;
////    }
//}
//
//class Graph {
//    private ArrayList<Node1> nodes;
//    private HashMap<Node1, ArrayList<Node1>> adj;
//
//    Graph() {
//        this.nodes = new ArrayList<>();
//        this.adj = new HashMap<>();
//    }
//
//    public static void addNode(Node1 a, Node1 b) {
//
//    }
//}
//
//
//public class NumberOfIslands {
//    public int numIslands(char[][] grid) {
//        int row = grid.length;
//        int column = grid[0].length;
//        HashMap<Node1, ArrayList<Node1>> allNodesWithNeighbours = new HashMap<>();
//        HashMap<String, Node1> indexToNode = new HashMap<>();
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                String nodeNumber = getNodeNumber(i, j);
//                if(grid[i][j] == '1') {
//                    Node1 node = new Node1(nodeNumber);
//                    indexToNode.put(Integer.toString(i)+Integer.toString(j), node);
//                    allNodesWithNeighbours.put(node, new ArrayList<Node1>());
//                }
//            }
//        }
//
//        System.out.println(indexToNode);
//
//        for (Map.Entry<Node1, ArrayList<Node1>> entry : allNodesWithNeighbours.entrySet()){
//                    System.out.println(entry.getKey().toString());
//        }
//
//        for (Map.Entry<Node1, ArrayList<Node1>> entry : allNodesWithNeighbours.entrySet()) {
//            Node1 nodeHere = entry.getKey();
//            String nodeNum = nodeHere.getValue();
//            int i = nodeNum.charAt(0) - '0';
//            int j = nodeNum.charAt(1) - '0';
//            ArrayList<Node1> neighbours = new ArrayList<>();
//            if (i+1 < row && grid[i + 1][j] == '1') {
//                int newRow = i+1;
//                neighbours.add(indexToNode.get(Integer.toString(newRow)+ Integer.toString(j)));
//                allNodesWithNeighbours.get(nodeHere).add(indexToNode.get(Integer.toString(newRow)+ Integer.toString(j)));
//            }
//            if(i-1 >=0 && grid[i-1][j] == '1'){
//                int newRow = i-1;
//                neighbours.add(indexToNode.get(Integer.toString(newRow)+ Integer.toString(j)));
//                allNodesWithNeighbours.get(nodeHere).add(indexToNode.get(Integer.toString(newRow)+ Integer.toString(j)));
//            }
//            if (j+1 < column && grid[i][j+1] == '1'){
//                int newCol = j+1;
//             //   neighbours.add(indexToNode.get(Integer.toString(i)+ Integer.toString(newCol)));
//                allNodesWithNeighbours.get(nodeHere).add(indexToNode.get(Integer.toString(i)+ Integer.toString(newCol)));
//            }
//            if (j-1 >=0 && grid[i][j-1] == '1'){
//                int newCol = j-1;
//                allNodesWithNeighbours.get(nodeHere).add(indexToNode.get(Integer.toString(i)+ Integer.toString(newCol)));            }
//        }
//
//        for (Map.Entry<Node1, ArrayList<Node1>> entry : allNodesWithNeighbours.entrySet()){
//            System.out.println(entry.getKey().toString()+" -> [ "+entry.getKey()+"]");
//        }
//
////
////
////        }
////
////
////            createGraph(allNodes);
//
//
//        return 0;
//    }
//
//    public int numIslands2(char[][] grid) {
//        int rows = grid.length;
//        int columns = grid[0].length;
//
//        boolean[][] visited = new boolean[rows][columns];
//
//        int count = 0;
//
//        for(int i = 0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                if(visited[i][j] == false && grid[i][j]=='1'){
//                    count++;
//                    DFSGrid(grid, i, j, visited);
//                }
//            }
//        }
//        return count;
//    }
//
//    public void DFSGrid(char[][] grid, int row, int column, boolean[][] visited){
//
//        visited[row][column] = true;
//
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int delrow[] = {-1,0,1,0};
//        int delColumn[] = {0,1,0,-1};
//
//        for(int i=0;i<4;i++){
//            int nrow= row+delrow[i];
//            int ncol = column +delColumn[i];
//            if(nrow >= 0  && nrow < n && ncol >= 0 && ncol < m
//                    && visited[nrow][ncol] == false && grid[nrow][ncol] == '1')
//            {
//                DFSGrid(grid, nrow, ncol, visited);
//            }
//        }
//    }
//        private void createGraph(ArrayList<Node1> allNodes) {
//
//    }
//
//
////        for (Node1 node : allNodes){
////
////            int i = Integer.toString(node.getValue()).charAt(0);
////            int j = Integer.toString(node.getValue()).charAt(1);
////            if(i-1 >=0 && i+1 < row && j-1 >=0 && j+1 <column && grid[i][j] =='1'){
////                ArrayList<Node1> neighbours = new ArrayList<>();
////                if(grid[i+1][j] == 1){
////                    int nodeName = getNodeNumber(i,j);
////                    neighbours.add();
////                }
////                if(grid [i-1][j] ==1)
////
////            }
//
//
//    public String getNodeNumber(int i, int j) {
//        String str = Integer.toString(i) + Integer.toString(j);
//        return str;
//    }
//
//
//    public static void main(String[] args) {
//        NumberOfIslands islands = new NumberOfIslands();
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                         {'1', '1', '0', '1', '0'},
//                         {'1', '1', '0', '0', '0'},
//                         {'0', '0', '0', '0', '0'}};
//        System.out.println(islands.numIslands2(grid));
//    }
//}
