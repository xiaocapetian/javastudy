package leetcode200;

public class l230 {
    int res;
    int frontNum=0;//用的是全局变量
    public int kthSmallest(TreeNode root, int k) {
        find(root,k);
        return res;
    }
    private void find(TreeNode root,int k){
        if(root==null){return ;}
        System.out.println("frontNum="+frontNum);
        find(root.left,k);
        frontNum++;
        if(frontNum==k){
            res = root.val;
        }
        find(root.right,k);
    }
}

