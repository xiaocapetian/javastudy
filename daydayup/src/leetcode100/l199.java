package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l199 {
    //自己写的！
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){queue.add(poll.left);}
                if (poll.right!=null){queue.add(poll.right);}
                if(i==size-1){
                    res.add(poll.val);
                }
            }

        }

        return res;
    }
}
