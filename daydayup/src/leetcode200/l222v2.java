package leetcode200;

public class l222v2 {
    public int countNodes(TreeNode root) {

        return getNumber(root);
    }
    int getNumber(TreeNode root){
        if(root==null)return 0;
        //另一种直接返回的可能,如果是个满二叉树,直接用公式返回
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left!=null){
            left = left.left;leftDepth++;
        }
        while (right!=null){
            right = right.right;rightDepth++;
        }
        if(leftDepth==rightDepth){
            return (2 << leftDepth)-1;
        }

        int leftNum = getNumber(root.left);
        int rightNum = getNumber(root.right);
        return leftNum+rightNum+1;
    }
}
