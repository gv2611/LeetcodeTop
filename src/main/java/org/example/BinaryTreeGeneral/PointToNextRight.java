package org.example.BinaryTreeGeneral;

import java.util.*;

class NodePoint {
    public int val;
    public NodePoint left;
    public NodePoint right;
    public NodePoint next;

    public NodePoint() {
    }

    public NodePoint(int _val) {
        val = _val;
    }

    public NodePoint(int _val, NodePoint _left, NodePoint _right, NodePoint _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class PointToNextRight {

    public NodePoint connect(NodePoint root) {
        if (root == null) {
            return null;
        }
        Queue<NodePoint> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NodePoint current = q.poll();
                if (i < size - 1) {
                    current.next = q.peek();
                }

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return root;
    }

    public NodePoint connect2(NodePoint root) {
        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<NodePoint>> nodes = new ArrayList<>();
        ArrayList<NodePoint> rootArr = new ArrayList<>(List.of(root));
        nodes.add(rootArr);

        while (true) {
            ArrayList<NodePoint> last = nodes.get(nodes.size() - 1);
            ArrayList<NodePoint> newLast = new ArrayList<>();
            for (NodePoint n : last) {
                if (n.left != null) {
                    newLast.add(n.left);
                }
                if (n.right != null) {
                    newLast.add(n.right);
                }
            }
            if (!newLast.isEmpty()) {
                nodes.add(newLast);
            } else {
                break;
            }
        }

        for (ArrayList<NodePoint> level : nodes) {
            NodePoint current = level.get(0);
            for (int i = 1; i < level.size(); i++) {
                current.next = level.get(i);
                current = level.get(i);
            }
        }

        return root;
    }

    public void printTree(NodePoint node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + "->" + node.next);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        PointToNextRight point = new PointToNextRight();
        NodePoint root = new NodePoint(1);
        root.left = new NodePoint(2);
        root.right = new NodePoint(3);
        root.left.left = new NodePoint(4);
        root.left.right = new NodePoint(5);
        root.right.right = new NodePoint(7);
        point.printTree(point.connect2(root));
    }
}
