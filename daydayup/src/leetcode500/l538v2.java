package leetcode500;

import java.util.Stack;

public class l538v2 {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)return null;
        //stack.add(root);//不能放进去
        TreeNode cur = root;
        int sum = 0;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }else {
                cur = stack.pop();
                cur.val += sum;
                sum = cur.val;

                cur = cur.left;
            }

        }

        return root;
    }
}
