package leetcode2000;

import java.util.*;

public class l2583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Long> list =new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);
                sum += poll.val;
            }
            list.add(sum);
        }
        list.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o2, o1);//int情况下o2-o1,long要改成Long.compare(o2, o1)
            }
        });

        //System.out.println(list);
        if(list.size()>=k){
            return list.get(k-1);
        }else return -1;
    }
}
