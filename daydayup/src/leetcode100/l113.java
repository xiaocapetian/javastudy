package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class l113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)return res;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        find(root,targetSum,root.val,path);
        return res;
    }
    public void find(TreeNode cur, int targetSum,int sum,List<Integer> path){
        System.out.println(path);
        if(cur.left==null&&cur.right==null){
            if(sum==targetSum){
                List<Integer> tmp = new ArrayList<>(path);
                res.add(tmp);
            }
        }
        if(cur.left!=null){
            path.add(cur.left.val);
            find(cur.left,targetSum,sum+cur.left.val,path);
            path.remove(path.size()-1);
        }
        if(cur.right!=null){
            path.add(cur.right.val);
            find(cur.right,targetSum,sum+cur.right.val,path);
            path.remove(path.size()-1);
        }

    }
}
