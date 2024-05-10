package leetcode100;

public class l114 {
    //二叉树怎么变链表呢?
    /*1.将左子树插入到右子树的地方
2.将原来的右子树接到左子树的最右边节点
3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
* */
    public void flatten(TreeNode root) {

        find(root);
    }
    public TreeNode find(TreeNode cur){
        if(cur==null){return null;}
        TreeNode right = cur.right;
        cur.right = cur.left;
        cur.left = null;
        TreeNode temp = cur;
        while (temp.right!=null){
            temp = temp.right;
        }
        temp.right = right;
        find(cur.right);
        return cur;
    }
}
