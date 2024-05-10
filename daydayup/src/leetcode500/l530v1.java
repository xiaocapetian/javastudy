package leetcode500;

public class l530v1 {
    //这是纯我自己写的,把我写绕进去了,让C老师教教我
    private TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        /*其余部分不应该写在主函数里面了,递归函数,传递带一个最小值,其实V0版就是把这个最小值变成全局变量罢了*/
        int res = Integer.MAX_VALUE;

        return inorder(root,res);
    }
    public int inorder(TreeNode root, int res){

        if(root == null) return res;
        //if(root.left==null&&root.right==null)return root.val;
/*        if(root.left!=null){
            int leftmin = getMinimumDifference(root.left);
            res = Math.min(leftmin, res);
        }  不要这样写,这样写把自己绕进去了*/
        res = inorder(root.left, res);

        if(pre!=null&&Math.abs(root.val-pre.val)<res){
            res = Math.abs(root.val-pre.val);
        }
        pre = root;
        //if(pre==null){
        //res = root.val;
        //}
/*        if(root.right!=null){
            int rightmin = getMinimumDifference(root.right);
            res = Math.min(rightmin,res);
        }*/
        // 计算右子树的最小差值
        res = inorder(root.right, res);
        //pre = root;
        /*pre 变量的更新不正确：在你的代码中，pre 变量是一个全局变量，用于跟踪上一个访问过的节点。但是你在递归函数中没有正确地更新 pre 变量。
        每次递归调用时，你应该将当前节点赋值给 pre，而不是在函数结束时赋值。这样可以确保 pre 始终指向当前节点的前一个节点。*/
        return res;
    }
}
