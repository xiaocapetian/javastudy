package leetcode100;

import java.util.Arrays;

public class l106 {
    //其实是我自己的思路
    public TreeNode buildTree(int[] inorder, int[] postorder) {//Inorder（中序遍历）Postorder（后序遍历)
        if(postorder.length==0)return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        //通过中序,找左右的分界点,mid位
        int mid = 0;
        while (mid < inorder.length){
            if(inorder[mid]==root.val)break;
            mid++;

        }
        //System.out.println("mid= "+mid);//然后把数组给切了,但是这样慢!
        root.left = buildTree(Arrays.copyOfRange(inorder,0,mid),
                Arrays.copyOfRange(postorder,0,mid));
        root.right = buildTree(Arrays.copyOfRange(inorder,mid+1,inorder.length),
                Arrays.copyOfRange(postorder,mid,postorder.length-1));
        //你看你看,细节要注意!!!!
        //为什么是这样切?因为对中序,mid位是顶部,mid位的右边才是
        // 对于后序来说,顶部在最后,而mid位是右边的第一个
        return root;
    }
}
