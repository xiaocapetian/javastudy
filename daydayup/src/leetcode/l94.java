package leetcode;

import leetcode100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class l94 {
    //中序遍历 左中右
    public List<Integer>  inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root,res);
        return res;
    }
    public void find(TreeNode root,List<Integer> res){
        if(root==null)return;

        find(root.left,res);
        res.add(root.val);
        find(root.right,res);
    }
}

