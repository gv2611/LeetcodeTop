package org.example.BinaryTreeGeneral;

import org.example.Tree;

class TreeNodeDepth{
    int val;
    TreeNodeDepth left;
    TreeNodeDepth right;
    TreeNodeDepth(){
    }
    TreeNodeDepth(int val){
        this.val = val;
    }
    TreeNodeDepth(int val, TreeNodeDepth left, TreeNodeDepth right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNodeDepth root) {
        if(root == null){
            return 0;
        }
        else{
            int leftDepth = maxDepth(root.left);
            int rightDepth =  maxDepth(root.right);
            if(leftDepth>rightDepth){
                return leftDepth+1;
            }
            else
                return rightDepth+1;
        }
    }


    public static void main(String[] args){

        MaximumDepthOfBinaryTree max = new MaximumDepthOfBinaryTree();
        TreeNodeDepth root = new TreeNodeDepth(3);
        root.left = new TreeNodeDepth(9);
        root.right = new TreeNodeDepth(20);
        root.right.left = new TreeNodeDepth(15);
        root.right.right = new TreeNodeDepth(7);
        System.out.println(max.maxDepth(root));

    }


}
