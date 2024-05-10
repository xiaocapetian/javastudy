package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class l105 {

    Map<Integer,Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i],i);
        }
        //TreeNode res = new TreeNode();
        return bulid(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode bulid(int[] preorder, int preorderbegin, int preorderend,
                           int[] inorder, int inorderbegin, int inorderend) {
        if(preorderbegin>preorderend)return null;
        TreeNode root = new TreeNode(preorder[preorderbegin]);//线序的第一个放进去
        if(preorderbegin==preorderend)return root;
        Integer mid = hash.get(preorder[preorderbegin]);//mid是哈希表的位置,总位置,不是子节点的位置

        int leftNodeCount = mid-inorderbegin+1;//左节点子树长度
        root.left = bulid(preorder,preorderbegin+1,preorderbegin+leftNodeCount-1,
                inorder,inorderbegin,mid-1);
        root.right = bulid(preorder,preorderbegin+leftNodeCount,preorderend,
                inorder,mid+1,inorderend);
        return root;
    }
}
