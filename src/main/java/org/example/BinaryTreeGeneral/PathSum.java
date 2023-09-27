package org.example.BinaryTreeGeneral;

import java.util.HashMap;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        boolean left = dfs(root.left, targetSum-root.val, visited);
        boolean right = dfs(root.right, targetSum-root.val, visited);

        if(left || right){
            return true;
        }

return false;


    }

    private boolean dfs(TreeNode node, int targetSum, HashMap<TreeNode, Boolean> visited) {

        int sum = 0;
        visited.put(node, true);

        while(node!=null && !visited.get(node)){
            sum = sum+node.val;

            dfs(node.left, targetSum, visited);
            dfs(node.right, targetSum, visited);
        }
        if(sum==targetSum){
            return true;
        }

        return false;

    }

    public static void main(String[] args){
        PathSum path = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(path.hasPathSum(root, 22));
    }
}
