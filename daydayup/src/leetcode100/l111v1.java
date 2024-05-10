package leetcode100;

public class l111v1 {
    public int minDepth(TreeNode root) {
        return find(root);
    }

    private int find(TreeNode root) {
        if(root==null){return 0;}
        int leftDepth=find(root.left);
        int rightDepth=find(root.right);
        if(root.left==null)return rightDepth+1;
        if(root.right==null)return leftDepth+1;
        //哎你看着这个多有意思,如果都是null,没关系!就在这等你呢!
        //只关注一个情况,有一个是null一个不是null,
        return Math.min(leftDepth,rightDepth)+1;
    }
}
