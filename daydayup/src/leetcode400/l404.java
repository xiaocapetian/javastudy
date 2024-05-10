package leetcode400;
//给定二叉树的根节点 root ，返回所有左叶子之和。
public class l404 {
    //原创的方法!!
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root);
    }
    public int sum (TreeNode root){
        if(root==null) return 0;
        int leftSum = sumleft(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum;
    }
    public int sumleft(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null){return root.val;}
        int leftSum = sumleft(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum;
    }
}
