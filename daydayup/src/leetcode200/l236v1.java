package leetcode200;

public class l236v1 {
    public static void main(String[] args) {
        /*
      3
     / \
    5   1
   / \ / \
  6  2 0  8
    / \
   7  4
        * */
        // 创建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        // 测试用例
        //TreeNode p = root.left; // 节点5
        TreeNode p = root.left.right.right; //4
        TreeNode q = root.left.right.left; // 节点7


        // 打印提示信息
        System.out.println("二叉树节点:");
        printTree(root);
        System.out.println();

        // 查找最近公共祖先
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println("\n\n节点 " + p.val + " 和节点 " + q.val + " 的最近公共祖先是: " + result.val);
    }

    // 打印二叉树
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    // 查找最近公共祖先的方法
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            System.out.println("lowestCommonAncestor执行，此时的root是null");
        }else {
        System.out.println("lowestCommonAncestor执行，此时的root是"+root.val);}

        // 如果树为空或者树的根节点为p或q，则根节点就是最近公共祖先
        if (root == null || root == p || root == q) {
            if(root==null){
                System.out.println("现在发现：root为空，现在要return的root是null");
            }else {
            System.out.println("现在发现：root节点为p或q，则根节点就是最近公共祖先，现在要return的root是"+root.val);
            }
            return root;
        }
        System.out.println("节点"+root.val+"无法提前return,得往下继续,(要递归了");
        System.out.println("即将对左子树递归");
        // 在左子树中寻找p和q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        System.out.println("即将对右子树递归");
        // 在右子树中寻找p和q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        System.out.println("开始判断如何return了,此时root.val在"+root.val);
        // 如果左子树中没有找到最近公共祖先，则结果在右子树中
        if (left == null) {
            if (right == null) {
            System.out.println("left == null，说明左子树中没有找到最近公共祖先，则结果在右子树中，" +
                    "此时return right 但是right也是null[现在左右都是null]所以最后return null");}
            else {
                System.out.println("left == null，说明左子树中没有找到最近公共祖先，则结果在右子树中，" +
                        "此时return right "+right.val);
            }
            return right;
        }
        // 如果右子树中没有找到最近公共祖先，则结果在左子树中
        if (right == null) {
            System.out.println("right == null,说明右子树中没有找到最近公共祖先，则结果在左子树中");
            System.out.println("此时return left ，left为"+left.val);

            return left;
        }

        // 如果左右子树中都找到了最近公共祖先，则根节点就是最近公共祖先
        System.out.println("左右都不是null,说明，左右子树中都找到了最近公共祖先，则根节点就是最近公共祖先");
        return root;
    }
}
