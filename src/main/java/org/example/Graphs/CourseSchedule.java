package org.example.Graphs;

import java.util.*;


class NodeCourse {
    int val;
    NodeCourse prerequisite;
    int startTime;
    int endTime;
    String color;
    boolean visited;

    NodeCourse(int val) {
        this.val = val;
        this.startTime = -1;
        this.endTime = -1;
        this.color = "WHITE";
        this.visited = false;
    }

}

class GraphCourse {
    HashMap<NodeCourse, ArrayList<NodeCourse>> adj;
    ArrayList<NodeCourse> nodes = new ArrayList<>();
    int time;

    GraphCourse() {
        this.adj = new HashMap<>();
        this.nodes = new ArrayList<>();
        this.time = 0;
    }

    void addNode(NodeCourse node) {
        this.nodes.add(node);
        this.adj.put(node, new ArrayList<>());
    }

    void addEdge(NodeCourse from, NodeCourse to) {
        this.adj.get(from).add(to);
    }
}

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, NodeCourse> courseNodeMapping = new HashMap<>();
        GraphCourse graph = new GraphCourse();

        for (int i = 0; i < numCourses; i++) {
            NodeCourse nodeCourse = new NodeCourse(i);
            courseNodeMapping.put(i, nodeCourse);
            graph.addNode(nodeCourse);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph.addEdge(courseNodeMapping.get(from), courseNodeMapping.get(to));
        }

        boolean output = true;
        for (int i = 0; i < numCourses; i++) {
            if (!courseNodeMapping.get(i).visited) {
                if (!dfsCanFinish(graph, courseNodeMapping.get(i))) {
                    output = false;
                    break;
                }
            }
        }
        return output;
    }


    private boolean dfsCanFinish(GraphCourse graph, NodeCourse node) {

        if (!node.color.equals("WHITE")) {
            return false;
        }

        System.out.println("Visiting node " + node);
        node.color = "GRAY";
        node.visited = true;
        for (NodeCourse child : graph.adj.get(node)) {
            if (!child.visited) {
                if (!dfsCanFinish(graph, child)) {
                    return false;
                }
            } else {
                if (child.color.equals("GRAY")) {
                    return false;
                }
            }
        }
        node.color = "BLACK";
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule course = new CourseSchedule();
        int numCourses = 2;
        //   2,1
        int prerequisites[][] = {{0, 1}, {1, 0}};
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

        System.out.println(course.canFinish(numCourses2, prerequisites3));

    }
}
