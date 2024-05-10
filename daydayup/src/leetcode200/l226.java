package leetcode200;

import leetcode100.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class l226 {//翻转二叉树
    //用层序遍历,自己想的方法  而且速度也很快噢!
    public TreeNode invertTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)return root;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                trans(poll);//那么在这一步把它的左右给翻转了
                if(poll.left!=null){queue.add(poll.left);}
                if(poll.right!=null){queue.add(poll.right);}
            }

        }
        return root;
    }
    public void trans(TreeNode root){

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    //事实上不用这么麻烦,root.left就算是null也可以正常翻转
        /*
        if(root.left==null&&root.right==null){
        }
        else if(root.left==null){root.left=root.right;root.right=null;}
        else if(root.right==null){root.right=root.left;root.left=null;}
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }*/
}
