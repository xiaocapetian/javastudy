package leetcode200;

public class l235 {
    //我自己写的噢!!!!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)return null;
        //lowestCommonAncestor(root.left,p,q);
        //lowestCommonAncestor(root.right,p,q);
/*每当到一个节点,如果发现pq在自己左右两侧,那就返回自己,否则递归调lowestCommonAncestor把自己左or右传进去*/
        if(root.val>p.val&&root.val>q.val){
            //return root.right;
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val&&root.val<q.val){
            //return root.left;
            return lowestCommonAncestor(root.right,p,q);
        }
        else {
            return root;
        }
    }
}
