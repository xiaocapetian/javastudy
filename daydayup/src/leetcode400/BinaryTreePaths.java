package leetcode400;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, currentPath, paths);
        return paths;
    }

    private void dfs(TreeNode node, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        if (node.left == null && node.right == null) {
            // 当前节点是叶子节点，将当前路径加入结果列表
            paths.add(new ArrayList<>(currentPath));
        } else {
            // 递归遍历左子树和右子树
            dfs(node.left, currentPath, paths);
            dfs(node.right, currentPath, paths);
        }

        // 回溯，移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<List<Integer>> paths = solution.binaryTreePaths(root);
        System.out.println("Paths from leaves to root:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
