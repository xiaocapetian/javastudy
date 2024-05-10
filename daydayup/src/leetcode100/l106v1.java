package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class l106v1 {
    //因为频繁的要在中序里查,所以定一个map
    Map<Integer,Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i],i);
        }
        //TreeNode res = new TreeNode();
        return bulid(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode bulid(int[] inorder, int inorderbegin, int inorderend ,
                          int[] postorder, int postorderbegin, int postorderend){

        if(postorderbegin>postorderend){return null;}

        TreeNode root = new TreeNode(postorder[postorderend]);
        /*在这里创TreeNode节点在这里就规定了它的子女是谁,调了函数
        * 那么在函数里也是创TreeNode节点,并返回去,父子就连上了,而不用在函数的返回值里传!!*/
        if(postorderbegin==postorderend){return root;}

        Integer mid = hash.get(postorder[postorderend]);
        int leftNodeCount = mid - inorderbegin; // 左子树节点数量   mid-中序的begin ,
        if (mid > inorderbegin) {
            root.left = bulid(inorder, inorderbegin, mid - 1,
                    postorder, postorderbegin, postorderbegin + leftNodeCount - 1);
        }
        /*mid是在中序找的,那么中序的索引,用mid,没有问题,左:inorderbegin,到mid - 1,
        *                                        右:mid + 1  到inorderend,
        * 但是到了后序,mid绝对位置就不准了,得用相对位置
        *          先求一个左的长度,mid-inorderbegin
        * 那么后序的索引  左 postorderbegin 到postorderbegin+(mid-inorderbegin)-1
        *           右postorderbegin+(mid-inorderbegin) ,postorderend - 1
        * */
        if (mid < inorderend) {
            root.right = bulid(inorder, mid + 1, inorderend,
                    postorder, postorderbegin + leftNodeCount, postorderend - 1);
        }
        //inorderend = mid -1;
        //postorderend =
        return root;
    }

}
