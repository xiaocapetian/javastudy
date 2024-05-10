package leetcode100;

public class l104v1 {
    //这个应该掌握
    public int maxDepth(TreeNode root) {
        return find(root);
    }
    public int find(TreeNode root){
//思路有点小细节啊!
        if(root==null){
            return 0;//看到null的时候说明到底了,那就返回0
        }
        int leftDepth=find(root.left);
        int rightDepth=find(root.right);
        return 1+Math.max(leftDepth,rightDepth);//这里返回的是左右哪个更大,再加1
    }

}
