package org.example.BinaryTreeGeneral;

class TreeNodeSameTree {
    int val;
    TreeNodeSameTree left;
    TreeNodeSameTree right;
    TreeNodeSameTree() {}
    TreeNodeSameTree(int val) { this.val = val; }
    TreeNodeSameTree(int val, TreeNodeSameTree left, TreeNodeSameTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class SameTree {
    public boolean isSameTree(TreeNodeSameTree p, TreeNodeSameTree q) {

        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args){
        SameTree same = new SameTree();
        TreeNodeSameTree root1 = new TreeNodeSameTree(1);
        root1.left = new TreeNodeSameTree(2);
        root1.right = new TreeNodeSameTree(3);
        TreeNodeSameTree root2 = new TreeNodeSameTree(1);
        root2.left = new TreeNodeSameTree(2);
        root2.right = new TreeNodeSameTree(3);
        System.out.println(same.isSameTree(root1, root2));
    }
}
