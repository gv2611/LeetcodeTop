package org.example.BinaryTreeGeneral;

import java.util.HashMap;

class TreeNodeInorderPostorder {
      int val;
      TreeNodeInorderPostorder left;
      TreeNodeInorderPostorder right;
      TreeNodeInorderPostorder() {}
      TreeNodeInorderPostorder(int val) { this.val = val; }
      TreeNodeInorderPostorder(int val, TreeNodeInorderPostorder left, TreeNodeInorderPostorder right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class BTFromInorderPostorder {

    public TreeNodeInorderPostorder buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return buildTreeUtil(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map );

    }

    private TreeNodeInorderPostorder buildTreeUtil(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {

        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNodeInorderPostorder root = new TreeNodeInorderPostorder(postorder[postEnd]);
        int indexRoot = map.get(root.val);
        int numLeft = indexRoot - inStart;

        root.left = buildTreeUtil(postorder, postStart, postStart+indexRoot-inStart-1, inorder, inStart, indexRoot-1, map);
        root.right = buildTreeUtil(postorder, postStart+indexRoot-inStart, postEnd-1, inorder, indexRoot+1, inEnd, map);
        return root;
    }

    public void printTree(TreeNodeInorderPostorder node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args){
        BTFromInorderPostorder btFromInorderPostorder = new BTFromInorderPostorder();
        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};
        btFromInorderPostorder.printTree(btFromInorderPostorder.buildTree(inorder, postorder));

    }
}
