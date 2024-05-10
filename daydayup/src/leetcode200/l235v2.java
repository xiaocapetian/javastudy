package leetcode200;

public class l235v2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//迭代法!  迭代法的思路也很简单啊!!!详细在v3
        while (root!=null){
            if(root.val>p.val&&root.val>q.val){
                root = root.left;
            }else if(root.val<p.val&&root.val<q.val){
                root = root.right;
            }else return root;
        }
        return null;
    }
}
