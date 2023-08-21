package org.example.Graphs;

import javax.print.DocFlavor;
import java.util.*;


class NodeCourse2 {
    int val;
    NodeCourse2 prerequisite;
    int startTime;
    int endTime;
    String color;
    boolean visited;

    NodeCourse2(int val) {
        this.val = val;
        this.startTime = -1;
        this.endTime = -1;
        this.color = "WHITE";
        this.visited = false;
    }

    boolean isVisited() {
        return !this.color.equals("WHITE");
    }

    public String toString() {
        return this.val + "," + this.color + "," + this.endTime;
    }

}

class GraphCourse2 {
    HashMap<NodeCourse2, ArrayList<NodeCourse2>> adj;
    ArrayList<NodeCourse2> nodes = new ArrayList<>();
    int time;

    GraphCourse2() {
        this.adj = new HashMap<>();
        this.nodes = new ArrayList<>();
        this.time = 0;
    }

    void addNode(NodeCourse2 node) {
        this.nodes.add(node);
        this.adj.put(node, new ArrayList<>());
    }

    void addEdge(NodeCourse2 from, NodeCourse2 to) {
        this.adj.get(from).add(to);
        System.out.println("adj : " + this.adj);
    }
}

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, NodeCourse2> courseNodeMapping = new HashMap<>();
        GraphCourse2 graph = new GraphCourse2();

        for (int i = 0; i < numCourses; i++) {
            NodeCourse2 nodeCourse = new NodeCourse2(i);
            courseNodeMapping.put(i, nodeCourse);
            graph.addNode(nodeCourse);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph.addEdge(courseNodeMapping.get(to), courseNodeMapping.get(from));
        }
        int time = 0;

        boolean output = true;
        for (int i = 0; i < numCourses; i++) {
            if (!courseNodeMapping.get(i).visited) {
                if (!dfsCanFinish(graph, courseNodeMapping.get(i), time)) {
                    output = false;
                    break;
                }
            }
        }
        if (!output) {
            return new int[0];
        }


        ArrayList<NodeCourse2> nodeCourseList = new ArrayList<>(courseNodeMapping.values());
        Collections.sort(nodeCourseList, new Comparator<NodeCourse2>() {
            @Override
            public int compare(NodeCourse2 node1, NodeCourse2 node2) {
                return Integer.compare(node2.endTime, node1.endTime);
            }
        });

        int arr[] = new int[numCourses];
        int i = 0;
        for (NodeCourse2 node : nodeCourseList) {
            arr[i] = node.val;
            i++;
        }
        return arr;
    }


    private boolean dfsCanFinish(GraphCourse2 graph, NodeCourse2 node, int time) {
        System.out.println("Node : " + node);
        if (!node.color.equals("WHITE")) {
            return true;
        }
        time++;
        node.startTime = time;

        node.color = "GRAY";
        for (NodeCourse2 child : graph.adj.get(node)) {
            if (!child.visited && !dfsCanFinish(graph, child, time)) {
                System.out.println("Child dfsCanFinish : " + node + "child :" + child);
                return false;
            } else if (child.color.equals("GRAY")) {
                System.out.println("Child is gray: " + child);
                // Cycle in graph
                return false;
            }
        }
        node.color = "BLACK";
        time++;
        node.endTime = time;
        return true;
    }


    public static void main(String[] args) {
        CourseSchedule2 course2 = new CourseSchedule2();
        int numCourses = 2;
        //   2,1
        int prerequisites[][] = {{0, 1},{1,0}};
        int numCourses2 = 5;
        int prerequisites2[][] = {{4, 1}, {3, 2}, {2, 4}};
        int numCourses3 = 5;
        int[][] prerequisites3 = {
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2}
        };
        int[][] prerequisites4 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int ar[] = course2.findOrder(2, prerequisites);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

}
