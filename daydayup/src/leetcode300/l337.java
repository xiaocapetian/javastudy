package leetcode300;

import leetcode100.TreeNode;

public class l337 {
    public int rob(TreeNode root) {
        int[] bp = find (root);
        return Math.max(bp[0],bp[1]);
    }
    public int[] find (TreeNode root){
        int[] bp = new int[2];
        if(root==null)return bp;
        int[] bpleft = find(root.left);
        int[] bpright = find(root.right);
        //bp[0]为要这个节点, 不要子节点
        bp[0] =root.val+bpleft[1]+bpright[1];
        //bp[1]为不要这个节点, 要子节点,要大的呀!!!
        /*bp[1] =bpleft[0]+bpright[0]; *///这是错的!

        //我都不要这个节点了我怕什么,子的哪个大我要哪个
        bp[1] = Math.max(bpleft[0],bpleft[1])+Math.max(bpright[0],bpright[1]);
        return bp;
    }
}
