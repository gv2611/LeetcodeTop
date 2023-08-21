package org.example.Graphs;

import java.util.*;

class NodeSurround {
    public int id;
    public boolean visited;
    public int group;
    public int startTime, endTime;
    public NodeSurround parent;
    public String color;

    public int distance;

    NodeSurround(int id) {
        this.id = id;
        this.reset();
    }

    int getId() {
        return this.id;
    }

    public String toString() {
        int parentId = -1;
        if (this.parent != null) {
            parentId = this.parent.id;
        }

        return "[" + this.id + " -> visited:" + this.visited + " group:" + this.group + ", (" + this.startTime + ":" + this.endTime + ") , parent:" + parentId + " " + this.color + " distance :"+this.distance+"] \n";
    }


    public void reset() {

        this.visited = false;
        this.group = 0;
        this.startTime = -1;
        this.endTime = -1;
        this.parent = null;
        this.color = "WHITE";
    }
}

class GraphSurround {
    private HashMap<NodeSurround, ArrayList<NodeSurround>> adj;
    private ArrayList<NodeSurround> nodeSurrounds;
    private int time;

    GraphSurround() {
        this.adj = new HashMap<>();
        this.nodeSurrounds = new ArrayList<>();
        this.time = 0;
    }

    public void addNode(NodeSurround x) {
        this.nodeSurrounds.add(x);
        this.adj.put(x, new ArrayList<>());
    }


    public void addEdge(NodeSurround a, NodeSurround b) {
        this.adj.get(a).add(b);
        this.adj.get(b).add(a);
    }

    public void dfs(NodeSurround nodeSurround, int group) {
        if (nodeSurround.visited) {
            return;
        }
        System.out.println("Visiting node " + nodeSurround);
        this.time++;
        nodeSurround.startTime = this.time;
        nodeSurround.color = "GRAY";
        nodeSurround.visited = true;
        nodeSurround.group = group;

        for (NodeSurround child : this.adj.get(nodeSurround)) {
            if (!child.visited) {
                //Set parent
                child.parent = nodeSurround;
                dfs(child, group);
            }
        }
        this.time++;
        nodeSurround.endTime = this.time;
        nodeSurround.color = "BLACK";
    }

    public void visitGraph() {
        for (NodeSurround nodeSurround : this.nodeSurrounds) {
            dfs(nodeSurround);
        }
    }

    public void visitGraphBFS() {
        for (NodeSurround nodeSurround : this.nodeSurrounds) {
            bfs(nodeSurround);
        }
    }

    public boolean areInSameComponent(NodeSurround a, NodeSurround b) {
        dfs(a);
        return b.visited;
    }

    public void dfs(NodeSurround a) {
        dfs(a, 0);
    }

    public void reset() {
        this.time = -1;
        for (NodeSurround nodeSurround : this.nodeSurrounds) {
            nodeSurround.reset();
        }
    }


    public int countConnectedComponents() {
        int numComponents = 0;
        for (NodeSurround nodeSurround : this.nodeSurrounds) {
            if (!nodeSurround.visited) {
                numComponents++;
                dfs(nodeSurround, numComponents);
            }
        }
        return numComponents;
    }

    public void printNode() {
        for (NodeSurround nodeSurround : this.nodeSurrounds) {
            System.out.print(nodeSurround);
        }
        System.out.println();
    }

    public void printGraph() {
        this.printNode();

        System.out.println("Adjacency list : ");

        for (Map.Entry<NodeSurround, ArrayList<NodeSurround>> entry : this.adj.entrySet()) {
            System.out.print(entry.getKey().getId() + " -> [");
            for (NodeSurround nodeSurround : entry.getValue()) {
                System.out.print(nodeSurround.getId() + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public ArrayList<NodeSurround> topologicalSort() {
        ArrayList<NodeSurround> output = new ArrayList<>();
        for (NodeSurround n : this.nodeSurrounds) {
            output.add(n);
        }
        output.sort((NodeSurround a, NodeSurround b) -> b.endTime - a.endTime);
        return output;
    }

    public void bfs(NodeSurround start) {
        if (start.visited) {
            return;
        }
        Queue<NodeSurround> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            NodeSurround nodeSurround = queue.poll();
            System.out.println("Visiting node: " + nodeSurround);
            //Visiting n
            nodeSurround.visited = true;
            for (NodeSurround child : this.adj.get(nodeSurround)) {
                if (!child.visited) {
                    child.parent = nodeSurround;
                    queue.add(child);

                }
            }
        }
    }

    public int findDistanceBetweenTwoNodes(NodeSurround a, NodeSurround b) {
        int distance = 1;
        a.distance=0;
        distance = bfsDistance(a, b, a.distance);

        return distance;

    }

    public int bfsDistance(NodeSurround start, NodeSurround destination, int distance) {
        Queue<NodeSurround> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            NodeSurround nodeSurround = queue.poll();
            System.out.println("Visiting node: " + nodeSurround);
            //Visiting n
            nodeSurround.visited = true;
            for (NodeSurround child : this.adj.get(nodeSurround)) {
                if (!child.visited && !child.color.equals("GRAY")) {
                    child.parent = nodeSurround;
                    child.distance = child.parent.distance+1;
                    child.color = "GRAY";
                    queue.add(child);

                    if(child.equals(destination)){
                        return child.distance;
                    }

                }
            }
        }
        return destination.distance;
    }

    public ArrayList<NodeSurround> printPathBetweenNodes(NodeSurround a, NodeSurround b){

        return bfsPath(a, b );

    }

    public ArrayList<NodeSurround> bfsPath(NodeSurround start, NodeSurround destination) {

        Queue<NodeSurround> queue = new LinkedList<>();
        ArrayList<NodeSurround> path  = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            NodeSurround nodeSurround = queue.poll();
            System.out.println("Visiting node: " + nodeSurround);
            //Visiting n
            nodeSurround.visited = true;
            for (NodeSurround child : this.adj.get(nodeSurround)) {
                if (!child.visited && !child.color.equals("GRAY")) {
                    child.parent = nodeSurround;
                    child.distance = child.parent.distance+1;
                    child.color = "GRAY";
                    queue.add(child);
                    if(child.equals(destination)){
                        path.add(destination);
                        while(!child.parent.equals(start)){
                            path.add(child.parent);
                            child=child.parent;
                        }
                        path.add(start);
                    }
                }
            }
        }
        return path;
    }
}


public class SurroundedRegions {
    public void solve(char[][] board) {

    }
    public static void main(String [] args){
        SurroundedRegions surround = new SurroundedRegions();
        char[][] matrix = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        surround.solve(matrix);
    }
}
