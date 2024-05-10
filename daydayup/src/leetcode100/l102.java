package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l102 {
    //二叉树的层序
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if(root == null){return res;}
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int cen = queue.size();//记录一下size这是这一层的数量,因为马上就要放下一层子女了
            for (int i = 0; i < cen ; i++) {
                TreeNode poll = queue.poll();
                //if(poll!=null){
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);
                list.add(poll.val);
                //}
            }

            if(list.size()!=0)res.add(list);
        }
        return res;
    }
}
