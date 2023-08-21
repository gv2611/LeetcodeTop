package org.example.GraphBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    int id;
    String color;
    boolean visited;
    int distance;

    Node(int val, int id) {
        this.id = id;
        this.val = val;
        color = "WHITE";
        this.visited = false;
        this.distance=-1;
    }

    public String toString() {
        return " " + this.val + "|" + this.color;
    }
}

class Graph {
    HashMap<Integer, ArrayList<Integer>> adj;
    HashMap<Integer, Node> gridToNode = new HashMap<>();

    Graph(HashMap<Integer, Node> gridToNode) {
        this.gridToNode = gridToNode;
        this.adj = new HashMap<>();


        // this.nodes = new ArrayList<>();
    }

    void addEdge(int to, int from) {
        if (!this.adj.containsKey(to)) {
            this.adj.put(to, new ArrayList<>());
        }

        this.adj.get(to).add(from);
    }
}

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int totalGrids = size * size;
        int row = size - 1;
        int column = 0;
        int gridNumber = 1;
        int c = 1;
        // Graph graph = new Graph(0);
        HashMap<Integer, Node> allNodes = new HashMap<>();

        while (row >= 0) {
            while (column < size && column >= 0) {
                Node newNode = new Node(board[row][column], gridNumber);
                allNodes.put(gridNumber, newNode);
                gridNumber++;
                column += c;
            }
            column = column - c;
            row--;
            c = c * -1;
        }

        Graph graph = new Graph(allNodes);

        for (int i = 1; i <= totalGrids; i++) {
            for (int j = i + 1; j <= i + 6 && j <= totalGrids; j++) {
                Node nodeJ = allNodes.get(j);
                if (nodeJ.val == -1) {
                    graph.addEdge(i, j);
                } else {
                    graph.addEdge(i, nodeJ.val);
                }
            }
        }
        allNodes.get(1).distance = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(allNodes.get(1));
        while (!q.isEmpty()) {
            Node n = q.poll();
            n.visited = true;
            if(!graph.adj.containsKey(n.id)){
                continue;
            }
            for(int child : graph.adj.get(n.id)){
                Node childNode = allNodes.get(child);
                if(!childNode.visited){
                    q.add(childNode);
                    childNode.visited= true;
                    childNode.distance = n.distance+1;
                }
            }
        }
        System.out.println(allNodes);

        return allNodes.get(totalGrids).distance;

    }

    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        int[][] array = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int [][] array2 = {{-1,-1,-1},{-1,9,8},{-1,8,9}};

        System.out.println(snakesAndLadders.snakesAndLadders(array2));
    }

}
