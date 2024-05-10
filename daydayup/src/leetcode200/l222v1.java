package leetcode200;

public class l222v1 {
    //后续遍历强大的!!!冲了 这个应该是能做出来的
    public int countNodes(TreeNode root) {

        return getNumber(root);
    }
    int getNumber(TreeNode root){
        if(root==null)return 0;
        int leftNum = getNumber(root.left);
        int rightNum = getNumber(root.right);
        return leftNum+rightNum+1;
    }
}
