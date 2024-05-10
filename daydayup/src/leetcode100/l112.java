package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l112 {//又是我自己写出来的,我厉害!
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        List<Integer> sumList = new ArrayList<>();
        return sum(root,targetSum,0);
    }
    public boolean sum (TreeNode root, int targetSum,int sum){//可改进,去掉sum,只传targetSum,遇到一个减一个,减到0说明可以
        if(root.left==null&&root.right==null){

            return sum+root.val==targetSum;
        }

        sum += root.val;

        if(root.left!=null&&root.right!=null){
            boolean left = sum(root.left,targetSum,sum);
            boolean right = sum(root.right,targetSum,sum);
            return left||right;
        }
        else if(root.right!=null){
            return sum(root.right,targetSum,sum);}
        else {
            return sum(root.left,targetSum,sum);}
        }

}
