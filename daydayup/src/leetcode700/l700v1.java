package leetcode700;

public class l700v1 {
    //迭代法!也很简单噢!!
    public TreeNode searchBST(TreeNode root, int val) {
        while (root!=null){
            if(root.val>val){
                root = root.left;
            }
            else if (root.val<val){
                root = root.right;
            }else {return root;}
        }
        return null;
    }

}
