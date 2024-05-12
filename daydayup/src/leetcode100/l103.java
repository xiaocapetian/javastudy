package leetcode100;

import java.util.*;

/**
 * 666一遍过
 * Collections.reverse(list);倒转list
 */
public class l103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        queue.add(cur);
        int count=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                if(now.left!=null)queue.add(now.left);
                if(now.right!=null)queue.add(now.right);
                list.add(now.val);
            }
            count++;
            if(count%2==0){
                Collections.reverse(list);}
            res.add(list);
        }
        return res;
    }
}
