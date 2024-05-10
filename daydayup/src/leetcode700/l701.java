package leetcode700;

public class l701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
//自己写的递归
        if(root==null)return new TreeNode(val);
        TreeNode cur = root;
        while (cur!=null){
            if(val> cur.val&&cur.right!=null){
                cur = cur.right;
            }else if(val> cur.val&&cur.right==null){
                cur.right = new TreeNode(val);
                return root;
            }
            else if(val< cur.val&&cur.left!=null){
                cur = cur.left;
            }else {
                cur.left = new TreeNode(val);
                return root;
            }
        }
        return null;
    }
}
