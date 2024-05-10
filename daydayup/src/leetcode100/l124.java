package leetcode100;

public class l124 {
    int max;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        find(root);
        return max;
    }

    private int find(TreeNode cur) {
        if (cur==null)return 0;
        int left = find(cur.left);
        int right = find(cur.right);

        max=Math.max(max,left+right+cur.val);//本题的关键在于,比大小比max时要用left+right+cur.val全部来比
        return Math.max(Math.max(left+cur.val,right+cur.val),0);//但是返回的时候只返回一条边
        //如果左右都不如0大就返回一个0算了

    }

}
