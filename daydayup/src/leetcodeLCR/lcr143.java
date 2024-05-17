package leetcodeLCR;

/**
 * 自己写的,和答案思路差不多
 */
public class lcr143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return findA(A,B);
    }

    private boolean findA(TreeNode a, TreeNode b) {
        if(a==null||b==null)return false;


        if(duibi(a,b))return true;
        if(findA(a.left, b))return true;
        if(findA(a.right,b))return true;

        return false;
    }

    private boolean duibi(TreeNode a, TreeNode b) {
        if(b==null)return true;

        if(a==null)return false;
        if(a.val!=b.val)return false;
        boolean b1 = duibi(a.left,b.left);
        boolean b2 = duibi(a.right,b.right);

        return b1&&b2;
    }

}
