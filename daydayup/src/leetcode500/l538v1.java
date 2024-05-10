package leetcode500;

public class l538v1 {
    int pre = 0;//随想录版本,和我想的基本一样,不需要返回值,直接修改
    public TreeNode convertBST(TreeNode root) {
        create(root);
        return root;
    }
    public void create(TreeNode root){
        if(root==null){
            return;
        }
        create(root.right);
        root.val += pre;
        pre = root.val;
        create(root.left);

    }
}
