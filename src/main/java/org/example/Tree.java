package org.example;


import java.util.ArrayList;

class Node{
    int key;
    Node left; Node right;
    Node(int node){
        key = node;
        left = right = null;
    }
}

public class Tree {
    Node root;

    ArrayList<Integer> preOrder = new ArrayList<>();
    ArrayList<Integer> postOrder = new ArrayList<>();
    ArrayList<Integer> inOrder = new ArrayList<>();

    void printInOrder ( Node node){
        if(node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.key+" ");
        printInOrder(node.right);
    }

    void printPreOrder( Node node){
        if(node == null)
            return;
        System.out.print(node.key+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printPostOrder(Node node){
        if(node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key+" ");
    }

    int height ( Node node ){

        if(node==null)
            return 0;
        int height = 1+Integer.max(height(node.left), height(node.right));
        return height;
    }

    public static void main(String [] args){
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node (5);
//        tree.root.right.left = new Node(6);
//        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.printPostOrder(tree.root);
        System.out.println();
        tree.printInOrder(tree.root);
        System.out.println();
        tree.printPreOrder(tree.root);
        System.out.println();

        System.out.println(tree.height(tree.root));
    }



}
