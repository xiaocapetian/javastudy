package leetcode500;

public class l538 {
    //自己想的!
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {

        return create(root);
    }
    public TreeNode create(TreeNode root){
        if(root==null)return null;

        root.right = create(root.right);
        root.val = root.val+sum;
        sum = root.val;
        root.left = create(root.left);
        return root;
    }
}
