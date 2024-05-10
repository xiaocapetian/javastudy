package leetcode600;

public class l617 {
    //自己写的,写复杂了!
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return createAdd(root1,root2);
    }
    public TreeNode createAdd(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null)return null;
        TreeNode root = new TreeNode();
        if(root1==null) {
            //直接替换成 return root2;
            root.val = root2.val;
            root.left = createAdd(null,root2.left);
            root.right = createAdd(null,root2.right);
        }else if(root2==null) {
            //直接替换
            root.val = root1.val;
            root.left = createAdd(root1.left,null);
            root.right = createAdd(root1.right,null);
        }else {
            //这里可以改,不用新建,root1+=root2,返回root1就行
        root.val = root1.val+root2.val;
        root.left = createAdd(root1.left,root2.left);
        root.right = createAdd(root1.right,root2.right);
        }
        return root;
    }
}
