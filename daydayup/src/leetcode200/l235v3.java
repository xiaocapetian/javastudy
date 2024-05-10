package leetcode200;

public class l235v3 {
    public static void main(String[] args) {
        // 构建二叉搜索树
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        /*
        6
       / \
      2   8
     / \ / \
    0  4 7  9
      / \
     3   5

        * */
        // 测试用例

        TreeNode p = root.left.left; // 节点值为0
        TreeNode q = root.left.right.right; // 节点值为5
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println("最近公共祖先节点的值为：" + result.val); // 预期输出为6
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 迭代法
        int count = 0;
        while (root != null) {
            count++;
            System.out.println("第"+count+"次while循环,此时的root的val是"+root.val);
            if (root.val > p.val && root.val > q.val) {
                System.out.println("root = root.left;");
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                System.out.println("root = root.right;");
                root = root.right;
            } else return root;
        }
        return null;
    }
}
