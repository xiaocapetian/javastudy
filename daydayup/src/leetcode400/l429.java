package leetcode400;

import java.util.*;

public class l429 {
    public List<List<Integer>> levelOrder(Node root) {

        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> queue= new ArrayDeque<>();
        queue.offer(root);

        //只要队列不空
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            //对于每一层
            for (int i = 0; i < size; i++) {
                //把他推出来
                Node cur = queue.poll();
                level.add(cur.val);
                //把他孩子放进去,增强for遍历每个孩子
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
