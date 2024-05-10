package leetcode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//用栈来模拟递归,这叫迭代法
public class l145v1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(pop==null){continue;}
            res.add(pop.val);
            stack.push(pop.left);
            stack.push(pop.right);
        }
        Collections.reverse(res);
        return res;
    }
}
