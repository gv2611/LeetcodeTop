//package org.example.Graphs;
//
//
//import org.example.Node1;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//class Node2 {
//    private String value;
//    private int isVisited;
//    ArrayList<Node2> neighbours;
//
//    Node2(String value) {
//        this.value = value;
//        this.isVisited = 0;
//        this.neighbours= new ArrayList<>();
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
//
//    public ArrayList<Node2> getNeighbours(){
//        return this.neighbours;
//    }
////    public String toString(Node1 node){
////        return node.;
////    }
//}
//
//class Graph2 {
//    private ArrayList<Node1> nodes;
//    private HashMap<Node2, ArrayList<Node1>> adj;
//
//    Graph2() {
//        this.nodes = new ArrayList<>();
//        this.adj = new HashMap<>();
//    }
//
//    public static void addNode(Node2 a, Node2 b) {
//
//    }
//}
//
//
//public class Islands2 {
//    public int numIslands(char[][] grid) {
//        int row = grid.length;
//        int column = grid[0].length;
//
//        Node2 nodesArray[][] = new Node2[row][column];
//        for(int i = 0 ;i< row;i++){
//            for(int j = 0; j< column;j++){
//                String name = getNodeNumber(i,j);
//                Node2 node = new Node2(name);
//                nodesArray[i][j] = node;
//            }
//        }
//        printArray(nodesArray);
//
//        for(int i = 0 ;i< row;i++){
//            for(int j = 0; j< column;j++) {
//            }
//            }
//        return 0;
//
//
//
//    }
//
//    public void printArray(Node2[][] nodeArray){
//
//        for(int i = 0; i< nodeArray.length;i++){
//            for(int j= 0; j< nodeArray[0].length;j++){
//                System.out.println(nodeArray[i][j].toString());
//            }
//        }
//    }
//
//    private void createGraph(ArrayList<Node2> allNodes) {
//
//    }
//
//
//
//    public String getNodeNumber(int i, int j) {
//        String str = Integer.toString(i) + Integer.toString(j);
//        return str;
//    }
//
//
//    public static void main(String[] args) {
//        Islands2 islands = new Islands2();
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//        System.out.println(islands.numIslands(grid));
//    }
//}
