package leetcode100;

import java.util.*;

public class l107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){return res;}
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){queue.add(poll.left);}
                if(poll.right!=null){queue.add(poll.right);}
            }
            res.add(list);

        }
        Collections.reverse(res);
        return res;
    }
}
