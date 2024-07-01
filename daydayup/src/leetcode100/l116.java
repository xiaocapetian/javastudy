package leetcode100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 可以的，一遍过
 */
public class l116 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {

        if(root==null)return null;
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node prenode = null;
            for(int i = 0;i<size;i++){

                Node poll = queue.poll();
                if(i==0){prenode = poll;}
                if(i==size-1){
                    prenode.next = null;
                }
                if(i!=0) {
                    prenode.next = poll;
                    prenode = poll;
                }

                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);


            }
        }
        return root;
    }
}
