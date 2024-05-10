package leetcode600;

public class l669 {
    //非常难啊!!抄的
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root==null)return null;
        if(root.val<low){
            //这个值比low还低,它的左子树也全部要删掉,但是右子树要进一步判断:是否要删掉
            TreeNode right = trimBST(root.right,low,high);
            /*这里,也要调用这个trimBST!*/
            return right;
        }else if(root.val>high){
            TreeNode left = trimBST(root.left,low,high);
            return left;
        }

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
