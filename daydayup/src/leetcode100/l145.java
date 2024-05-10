package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l145 {
    //后序遍历 左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root,res);
        return res;
    }
    public void find(TreeNode root,List<Integer> res){
        if(root==null)return;

        find(root.left,res);
        find(root.right,res);
        res.add(root.val);
    }
}
