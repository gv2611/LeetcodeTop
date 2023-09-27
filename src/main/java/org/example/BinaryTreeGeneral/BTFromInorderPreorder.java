package org.example.BinaryTreeGeneral;

import java.util.HashMap;

class TreeNodeInorderPreorder {
      int val;
      TreeNodeInorderPreorder left;
      TreeNodeInorderPreorder right;
      TreeNodeInorderPreorder() {}
      TreeNodeInorderPreorder(int val) { this.val = val; }
      TreeNodeInorderPreorder(int val, TreeNodeInorderPreorder left, TreeNodeInorderPreorder right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BTFromInorderPreorder {
    public TreeNodeInorderPreorder buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeUtil(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

    }

    public TreeNodeInorderPreorder buildTreeUtil(int [] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNodeInorderPreorder root = new TreeNodeInorderPreorder(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeUtil(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        root.right = buildTreeUtil(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, map);
        return root;

    }

    public void printTree(TreeNodeInorderPreorder node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String [] args){
        BTFromInorderPreorder btFromInorderPreorder = new BTFromInorderPreorder();
        int preOrder[] = {3,9,20,15,7};
        int inOrder[] = {9,3,15,20,7};
        btFromInorderPreorder.buildTree(preOrder, inOrder);
    }

}
