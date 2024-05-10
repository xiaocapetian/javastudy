package kama;

import java.util.Scanner;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode(char val,TreeNode left,TreeNode right){
        this.val =val;
        this.left =left;
        this.right =right;
    }
}
public class k21 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String qianStr = str.split(" ")[0];
            String zhongStr = str.split(" ")[1];
            char[] qian = qianStr.toCharArray();
            char[] zhong = zhongStr.toCharArray();
            TreeNode root = build(qian,0,qian.length-1,zhong,0,zhong.length-1);
            houFind(root);
            System.out.println();
        }
    }
    public static TreeNode build(char[] qian,int qianStart,int qianEnd,
                                 char[] zhong,int zhongStart,int zhongEnd){
        // for(int i =qianStart;i<= qianEnd;i++ ){
        //     System.out.print(qian[i]);
        // }
        if(qianStart>qianEnd){
            return null;
        }
        if(qianStart==qianEnd){
            return new TreeNode(qian[qianStart],null,null);
        }
        int qie = zhongStart;
        while(zhong[qie]!=qian[qianStart]){
            qie++;
        }
        //qie是中点的绝对坐标
        int leftlen = qie-zhongStart;//左的长度

        TreeNode leftchild = build(qian,qianStart+1,qianStart+leftlen,
                zhong,zhongStart,qie-1);
        TreeNode rightchild = build(qian,qianStart+leftlen+1,qianEnd,
                zhong,qie+1,zhongEnd);
        TreeNode treeNode = new TreeNode(qian[qianStart],leftchild,rightchild);
        return treeNode;
    }
    public static void houFind(TreeNode cur){
        if(cur==null){return;}
        houFind(cur.left);
        houFind(cur.right);
        System.out.print(cur.val);
    }
}