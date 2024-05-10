package leetcode200;

public class l236 {
//非难难啊.在v1版本做了详细的拆分,现在我自己也来写一遍!
    //写起来很简单,重点是能理解!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)return null;
        if(root==p||root==q)return root;

        //不能return,那就要往下递归了
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        /*这题从上往下想好像好想,左找不到,那说明在右,.右找不到,说明在左*/
        if(left==null)return right;
        if(right==null)return left;
//左右都找到了,那根节点就是
        return root;
    }

}
