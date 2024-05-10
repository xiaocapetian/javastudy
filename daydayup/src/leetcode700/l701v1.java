package leetcode700;

public class l701v1 {
    //这题反而是递归难思考一点啊
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        if(root.val<val){
            root.right = insertIntoBST(root.right,val);
            //返回值直接赋给它的子树别怕覆盖了
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }
        //为什么不怕覆盖呢?因为返回的是root,只有是null的时候才会改动!
        return root;//为什么不怕覆盖呢?---传入谁返回谁,传入root.right,返回给root.right,找到传入的是空的那一个
    }
}
