package leetcode200;

import java.util.LinkedList;
import java.util.Queue;

public class l222 {
    //先写个层序
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res++;
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);
            }
        }
        return res;
    }
}
