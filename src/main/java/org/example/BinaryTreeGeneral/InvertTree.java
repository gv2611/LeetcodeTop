package org.example.BinaryTreeGeneral;

class TreeNodeInvert {
    int val;
    TreeNodeInvert left;
    TreeNodeInvert right;
    TreeNodeInvert() {}
    TreeNodeInvert(int val) { this.val = val; }
    TreeNodeInvert(int val, TreeNodeInvert left, TreeNodeInvert right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertTree {

    public TreeNodeInvert invertTree(TreeNodeInvert root) {

        if(root==null){
            return null;
        }

        TreeNodeInvert left = invertTree(root.left);
        TreeNodeInvert right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;



    }

    public void printTree(TreeNodeInvert node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args){
        InvertTree invert = new InvertTree();
        TreeNodeInvert root1 = new TreeNodeInvert(4);
        root1.left = new TreeNodeInvert(2);
        root1.left.left = new TreeNodeInvert(1);
        root1.left.right = new TreeNodeInvert(3);
        root1.right = new TreeNodeInvert(7);
        root1.right.left = new TreeNodeInvert(6);
        root1.right.right = new TreeNodeInvert(9);
        TreeNodeInvert op = invert.invertTree(root1);
        invert.printTree(op);

    }



}
