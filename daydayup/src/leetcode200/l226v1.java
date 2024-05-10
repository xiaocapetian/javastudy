package leetcode200;

import leetcode100.TreeNode;

public class l226v1 {
    //前序遍历来翻转
    public TreeNode invertTree(TreeNode root){
        if(root==null)return root;
        trans(root);              //先把自己的左右翻转
        invertTree(root.left);    //再把左孩子喊过来
        invertTree(root.right);   //再把右孩子喊过来
        //其实你看👆,除了第一次调用,其他的也不用返回值
        return root;//所以这里简单返回一下root就行了
    }
    public void trans(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
