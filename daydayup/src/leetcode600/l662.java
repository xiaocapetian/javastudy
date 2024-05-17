package leetcode600;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 我这里为了让树节点能有编号,新建了一个类,带上了编号,不然就得把队列换成LinkedHashMap但是还是挺麻烦的
 * 思路还是看来答案啊,每个树节点都要有编号,
 * 假设父节点的编号是n,左儿子的编号就是2*n,右儿子的编号就是2*n+1,
 */
public class l662 {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<numTreeNode> queue = new LinkedList<>();
        //LinkedHashMap<TreeNode,Integer> queue = new LinkedHashMap<>();
        queue.add(new numTreeNode(1,root));

        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            numTreeNode first = queue.peek();
            int left = first.num;
            int right = first.num;
            for (int i = 0; i < size; i++) {
                numTreeNode poll = queue.poll();
                if(poll.treeNode.left!=null){
                    queue.add(new numTreeNode(poll.num*2,poll.treeNode.left));
                }
                if(poll.treeNode.right!=null){
                    queue.add(new numTreeNode(poll.num*2+1,poll.treeNode.right));
                }
                right = poll.num;
            }
            int cha = right - left+1;
            res = Math.max(cha,res);
        }
        return res;
    }
    class numTreeNode {
        int num;
        TreeNode treeNode;
        numTreeNode(int num,TreeNode treeNode){
            this.num = num;
            this.treeNode = treeNode;
        }
    }
}
