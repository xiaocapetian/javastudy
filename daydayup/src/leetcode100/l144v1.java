package leetcode100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//用栈来模拟递归,这叫迭代法
public class l144v1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();//顶上的弹出来,
            if(pop==null){continue;}
            res.add(pop.val);
            stack.push(pop.right);//左右压进去
            stack.push(pop.left);
        }
        return res;
    }
}
