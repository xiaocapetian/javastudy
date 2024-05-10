package leetcode100;

public class l104 {
    //最大深度  这是我自己写的
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int depth = 1;
        return find(root,depth);
    }

    public int find(TreeNode root,int depth){
        int leftDepth=depth,rightDepth=depth;   //需要传一个depth
//        if(root==null){
//            return res;
//        }
        if(root.left!=null)leftDepth=find(root.left,depth+1);
        if(root.right!=null)rightDepth=find(root.right,depth+1);
        return Math.max(leftDepth,rightDepth);
    }
}
