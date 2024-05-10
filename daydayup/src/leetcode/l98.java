package leetcode;

public class l98 {
//自己想失败了!!
    /**这个很难!!!仔细思考!!
     * z*/
    //private long prev = Long.MIN_VALUE;
    private TreeNode pre = null;//也可以不存最小值,而是存上一个节点的值就行啦

    public boolean isValidBST(TreeNode root) {

        return inorder(root);
    }
    //用的是中序--搜索树当然是中序
    public boolean inorder (TreeNode root){
        if(root==null)return true;

        boolean left = inorder(root.left);//先左
        //if(!left)return false;

        /*当前节点的值是不是大于prev(是左子树的最大值!)*/
        //为什么要定义Long.MIN_VALUE;一定要保证可能最小的比它还小
        /*
        if(root.val>prev){prev = root.val;}//如果是,更新一下左子树的最大值
        else return false;
        */
        if(pre == null || root.val > pre.val){
            pre = root;
        }else return false;
        //如果不满足就直接flase了
        //想象一下,因为是中序遍历,左中右,所以只要一路递增,就没有问题,遍历一个就把值变成prev


        boolean right = inorder(root.right);//最后右
        return left&&right;
    }

}
