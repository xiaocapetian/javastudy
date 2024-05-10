package leetcode400;

public class l450v1 {
    //递归法!
    public TreeNode deleteNode(TreeNode root, int key) {
        //递归什么时候终止,是在找到要删的点的时候终止!所以删除的操作就写在终止条件里
        if(root==null)return null;
        if(root.val==key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right != null){
                return root.right;
            }else {
                //左右都不为空,让右来继位,让左转移到右的最左的左下角
                TreeNode findleft = root.right;
                while (findleft.left!=null){
                    findleft = findleft.left;
                }
                findleft.left = root.left;
                return root.right;//右继位了
            }
        }

        //下面才是递归
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

}
