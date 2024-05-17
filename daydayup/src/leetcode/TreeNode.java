package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public static void printBinaryTreeStructure(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    System.out.print(curr.val + " ");
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println(); // Print a newline after each level
        }
    }

}
