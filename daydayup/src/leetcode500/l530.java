package leetcode500;

public class l530 {
    //private TreeNode pre = new TreeNode();
    private TreeNode pre;
    private int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(pre!=null&&Math.abs(root.val-pre.val)<res){
            res = Math.abs(root.val-pre.val);

        }
        pre = root;
        inorder(root.right);

    }
}
