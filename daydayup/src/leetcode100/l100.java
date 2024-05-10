package leetcode100;

public class l100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return contrast(p,q);
    }

    private boolean contrast(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        else if(p==null||q==null)return false;
        else {
            if(p.val!=q.val){return false;}
            else {
                return contrast(p.left,q.left)&&contrast(p.right,q.right);
            }
        }

    }
}
