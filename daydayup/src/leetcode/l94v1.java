package leetcode;

import leetcode100.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class l94v1 {
    //中序的迭代法难度比较大啊 自己写一遍
    public List<Integer>  inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){return res;}
        TreeNode cur = root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){        //没碰到底
                stack.push(cur);  //进栈
                cur = cur.left;   //继续往左碰
            }else {
                cur = stack.pop();  //碰到底了,弹出
                res.add(cur.val);   //左中右!
                cur = cur.right;    //再看它的右
            }
        }
        return res;
    }


    //抄的
    public List<Integer>  inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        TreeNode cur = root;

        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                cur = stack.pop();
                result.add(cur.val);
                //这个会忘掉!
                cur = cur.right;
            }
        }
        return result;
    }
}
