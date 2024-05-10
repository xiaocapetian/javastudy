package leetcode400;

public class l450 {
    public TreeNode deleteNode(TreeNode root, int key) {
//自己写的迭代法,但是我忘了删节点应该是让父的子=子的子,让孙子连上爷爷,继位
        TreeNode cur = root;
        //要记录一个cur的parent   因为删除节点时得把父节点和孙节点连上
        TreeNode parent = null;
        while (cur!=null){
            if(cur.val< key){
                parent = cur;
                cur = cur.right;
            }else if(cur.val>key){
                parent = cur;
                cur = cur.left;
            }else {
                //找到要删的点了
                if(cur.left==null&&cur.right==null){//没有子节点
                    if(parent==null){root=null;}
                    else if(parent.left==cur){parent.left = null;}
                    else {parent.right = null;}
                    //cur = null;
                }else if(cur.left==null){//左子是空,右子继位
                    if(parent==null){root=cur.right;}
                    else if(parent.left==cur){parent.left = cur.right;}
                    else {parent.right = cur.right;}
                    //cur = cur.right;
                }else if(cur.right==null){//没有右子,左子继位
                    if(parent==null){root=cur.left;}
                    else if(parent.left==cur){parent.left = cur.left;}
                    else {parent.right = cur.left;}
                    //cur = cur.left;
                }else {
                    //左右都不是空
                    //左右都可以继位,假设让右来继位,左集团要放到右集团的最左的左下角

                    if(parent==null){root=cur.right;}
                    else if(parent.left==cur){parent.left = cur.right;}
                    else {parent.right = cur.right;}

                    //右现在继位了,左怎么办?
                    TreeNode left = cur.left;//左在这
                    TreeNode ll = cur.right;//找到右派
                    while (ll.left!=null){
                        ll = ll.left;
                    }
                    ll.left = left;


                }
                return root;
            }
        }
        return root;
    }

}
