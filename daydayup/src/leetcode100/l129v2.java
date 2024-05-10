package leetcode100;

/**
 * 这个其实挺难理解的
 */
public class l129v2 {
    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }
    private int dfs(TreeNode cur,int prevSum){
        if(cur==null)return 0;
        int sum = prevSum*10+cur.val;
        if(cur.left==null&&cur.right==null){
            return sum;
        }
        int left = dfs(cur.left,sum);
        int right = dfs(cur.right,sum);//向下找到时候带了目前的路径值
        return left+right;
    }
}
