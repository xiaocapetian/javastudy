package leetcode500;

import java.util.LinkedList;
import java.util.Queue;

public class l513 {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                if(i==0){res = poll.val;}
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);

            }
        }
        return res;
    }
}
