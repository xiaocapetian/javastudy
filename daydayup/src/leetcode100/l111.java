package leetcode100;

public class l111 {
    public int minDepth(TreeNode root) {
        if(root==null){return 0;}
        return find(root);
    }
    public int find(TreeNode root){
        //它这个的意思是,一个null空的是不算子树的
        //这是我自己写的,找:什么是子节点↓↓
        if(root.left==null&&root.right==null){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;//等着被覆盖掉
        if(root.left!=null){leftDepth = find(root.left);}
        if(root.right!=null){rightDepth = find(root.right);}
        return Math.min(leftDepth,rightDepth)+1;

    }
}
