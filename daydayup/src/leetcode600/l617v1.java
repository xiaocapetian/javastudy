package leetcode600;

public class l617v1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return createAdd(root1,root2);
    }
    public TreeNode createAdd(TreeNode root1, TreeNode root2){
        if(root1==null) {
            return root2;
        }else if(root2==null) {
            return root1;
        }else {
//            TreeNode root = new TreeNode();
//            root.val = root1.val+root2.val;
//            root.left = createAdd(root1.left,root2.left);
//            root.right = createAdd(root1.right,root2.right);
            root1.val+=root2.val;
            root1.left = createAdd(root1.left,root2.left);
            root1.right = createAdd(root1.right,root2.right);
            return root1;
        }
    }
}
