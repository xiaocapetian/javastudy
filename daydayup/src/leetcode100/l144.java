package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l144 {//前序遍历中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root,res);
        return res;
    }
    public void find (TreeNode root,List<Integer> res){
        if (root == null) {
            return;
        }
        res.add(root.val);
        find(root.left,res);
        find(root.right,res);
    }
}
