package leetcode800;

public class l889 {
//我真是太失败了,,,,废柴
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return create(preorder,0,preorder.length-1,
                postorder,0,postorder.length-1);
    }
    public TreeNode create(int[] preorder, int prebegin,int preend,
                           int[] postorder, int postbegin,int postend){
        if(prebegin>preend)return null;
        if(prebegin==preend)return new TreeNode(preorder[prebegin]);

        //preorder[postbegin]是中间节点的值
        //int mid = hashMap.get(preorder[postbegin]);//mid是中间节点在前序的绝对索引
        int leftmid = preorder[prebegin+1];//左子节点的中间节点值
        int leftmidInpost = postbegin;
        for(;leftmidInpost<=postend;leftmidInpost++){
            if(postorder[leftmidInpost]==leftmid){
                break;
            }
        }//leftmidInpost左子树中间节点在后序中的绝对索引


        //System.out.println("leftmidInpost= "+leftmidInpost);
        int leftLength = leftmidInpost-postbegin+1;
        //System.out.println("leftLength = "+leftLength);

        TreeNode root = new TreeNode(preorder[prebegin]);
        root.left=create(preorder,prebegin+1,prebegin+1+leftLength-1,
                postorder,postbegin,leftmidInpost);
        root.right = create(preorder,prebegin+leftLength+1,preend,
                postorder,leftmidInpost+1,postend-1);
        return root;
    }

}
