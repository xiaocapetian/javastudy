package leetcode500;

public class l543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDirect(root);
        return max;
    }
    public int getDirect(TreeNode cur){
        if(cur ==null){
            return 0;}
        int left = getDirect(cur.left);
        int right = getDirect(cur.right);
        int maxlen = Math.max(left,right);
        if(max<left+right){max = left+right;}
        return maxlen+1;

    }
}
