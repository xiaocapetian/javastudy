package leetcode200;

/**
 * 自己写思路没问题了可以理解,就是还有这个细节👇
 * [易错]!!这里返回的是什么?你能返回cur.left吗?错!返回的不是自己的子节点,而是查询的结果!
 */
public class l236v2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root,p,q);
        return res;
    }

    private TreeNode find(TreeNode cur, TreeNode p, TreeNode q) {
        if(cur==null)return null;
        if(cur == p||cur==q){
            return cur;
        }

        TreeNode resleft = find(cur.left, p, q);
        TreeNode resright= find(cur.right,p,q);


        if(resleft!=null&&resright!=null){return cur;}
        else if(resleft!=null){
            return resleft;/*[易错]!!这里返回的是什么?你能返回cur.left吗?错!返回的不是自己的子节点,而是查询的结果!*/ //return cur.left
        }else if(resright!=null){
            return resright;
        }else{
            return null;
        }
    }
}
