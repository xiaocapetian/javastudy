package leetcode200;

public class l230v1 {
    //跟我自己写的差别不大,可以学一下怎么把输入变量变成全局变量
    int res, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        //if (k == 0) return;
        k--;
        if (k == 0) res = root.val;
        dfs(root.right);
    }
//    作者：Krahets
//    链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2361685/230-er-cha-sou-suo-shu-zhong-di-k-xiao-d-n3he/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
