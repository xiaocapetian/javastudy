package leetcode100;

public class l101v1 {
    /**递归法
     * */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if(left==null&&right==null){return true;}
        if(left==null&&right!=null){return false;}
        if(left!=null&&right==null){return false;}
        if(left.val!=right.val){return false;}
        //以上都不符合,说明都有值且相等,继续比 // 此时才做递归，做下一层的判断
        //比的是:外侧,和 内侧
        boolean waice = compare(left.left,right.right);
        boolean neice = compare(left.right,right.left);
        return waice&&neice;
    }
}
