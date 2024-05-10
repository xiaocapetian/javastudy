package leetcode100;

public class l110 {
    //我自己写的噢!!!
    public boolean isBalanced(TreeNode root) {
        if(childcount(root)<0)return false;
        else return true;
    }
    public int childcount(TreeNode root){
        if(root==null)return 0;
        int leftChild = childcount(root.left);
        int rightChild = childcount(root.right);
        if(leftChild==rightChild)return leftChild+1;
        else if(Math.abs(leftChild-rightChild)==1){
            return leftChild>rightChild?leftChild+1:rightChild+1;}
        else return Integer.MIN_VALUE;
    }
}

