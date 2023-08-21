package org.example.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Node3 {
    public int val;
    public List<Node3> neighbors;

    public boolean visited;
    public Node3() {
        val = 0;
        visited = false;
        neighbors = new ArrayList<Node3>();
    }
    public Node3(int _val) {
        val = _val;
        visited = false;
        neighbors = new ArrayList<Node3>();
    }
    public Node3(int _val, ArrayList<Node3> _neighbors) {
        val = _val;
        visited = false;
        neighbors = _neighbors;
    }

    public String toString(){
        return " "+val + "-> "+neighbors;
    }
}


public class CloneGraph {
    public Node3 cloneGraph(Node3 node) {
        System.out.println("Main node");
        System.out.println(node);
        List<Node3> neighbours = node.neighbors;
        Node3 newNode = new Node3(node.val, (ArrayList<Node3>) node.neighbors);
        Node3 backup = newNode;
        int visited[] = new int [101];
        Arrays.fill(visited, 0);
        visited[node.val] = 1;

        for(Node3 neighbor : neighbours){
            if(visited[neighbor.val]!=1) {
                DFS(neighbor, newNode, visited);
            }

        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        System.out.println(backup.val);
        return backup;
    }

    private void DFS(Node3 node, Node3 newNode, int[] visited) {

        visited[node.val] = 1;
        System.out.println("Visiting : "+node.val);

        List<Node3> neighbors = node.neighbors;

        for(Node3 neighbor : neighbors){
            Node3 newNo = new Node3(neighbor.val);
            newNo.neighbors = neighbor.neighbors;
            if(visited[neighbor.val]!=1) {
                DFS(neighbor, newNode, visited);
            }
        }
    }

    public static void main(String args[]){
        CloneGraph clone = new CloneGraph();
        ArrayList<Node3> allNodes = new ArrayList<>();

        for(int i = 0; i<=4;i++){
            Node3 node = new Node3(i, new ArrayList<Node3>());
            allNodes.add(node);
        }

        allNodes.get(1).neighbors.add(allNodes.get(2));
        allNodes.get(1).neighbors.add(allNodes.get(4));
        allNodes.get(2).neighbors.add(allNodes.get(3));
        allNodes.get(3).neighbors.add(allNodes.get(4));
        System.out.println(clone.cloneGraph(allNodes.get(1)));
    }
}
