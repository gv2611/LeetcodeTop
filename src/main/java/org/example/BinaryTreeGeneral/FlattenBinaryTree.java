package org.example.BinaryTreeGeneral;

import java.util.ArrayList;

class TreeNodeFlatten {
      int val;
      TreeNodeFlatten left;
      TreeNodeFlatten right;
      TreeNodeFlatten() {}
      TreeNodeFlatten(int val) { this.val = val; }
      TreeNodeFlatten(int val, TreeNodeFlatten left, TreeNodeFlatten right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class FlattenBinaryTree {

    public TreeNodeFlatten flatten(TreeNodeFlatten root) {

        if(root==null){
            return null;
        }
        ArrayList<TreeNodeFlatten> pre = new ArrayList<>();

        preOrder(root, pre);
        if(pre.size() == 1){
            return root;
        }

        TreeNodeFlatten current = pre.get(0);
        for(int i = 1; i< pre.size(); i++){
            current.left = null;
            current.right = pre.get(i);
            current = current.right;
        }
        return root;
    }

    private void preOrder(TreeNodeFlatten root, ArrayList<TreeNodeFlatten> pre) {
        if(root==null){
            return;
        }
        pre.add(root);
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    public void printTree(TreeNodeFlatten node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args){
        FlattenBinaryTree flatten = new FlattenBinaryTree();
        TreeNodeFlatten root = new TreeNodeFlatten(0);
        root.left = new TreeNodeFlatten(2);
        root.right = new TreeNodeFlatten(5);
        root.left.left = new TreeNodeFlatten(3);
        root.left.right = new TreeNodeFlatten(4);
        root.right.right = new TreeNodeFlatten(6);

        flatten.printTree(flatten.flatten(root));
    }
}
