package leetcode900;

public class l938 {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {

        find(root,low,high);
        return res;
    }
    public void find(TreeNode root, int low, int high){
        if(root==null)return;
        if(low>root.val){
            find(root.right, low, high);
        }else if(high<root.val){
            find(root.left,low,high);
        }
        else {
            find(root.left,low,high);

            if(root.val>=low&&root.val<=high){
                res = res + root.val;
            }
            find(root.right, low, high);
        }
    }
}
