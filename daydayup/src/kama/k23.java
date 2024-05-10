package kama;

import java.util.Scanner;

public class k23 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = Integer.parseInt(sc.nextLine());
            String qianstr = sc.nextLine();
            String zhongstr = sc.nextLine();
            char[] qian=qianstr.toCharArray();
            char[] zhong=zhongstr.toCharArray();
            TreeNode root = build(qian,0,qian.length-1,
                    zhong,0,qian.length-1);
            System.out.println(find(root));
        }
    }
    public static int find(TreeNode cur){
        if(cur==null){
            return 0;
        }
        int leftDepth = find(cur.left);
        int rightDepth = find(cur.right);
        return Math.max(leftDepth ,rightDepth)+1;
    }
    public static TreeNode build(char[] qian,int qianStart,int qianEnd,
                                 char[] zhong,int zhongStart,int zhongEnd){
        if(qianStart>qianEnd){return null;}
        if(qianStart==qianEnd){return new TreeNode(qian[qianStart],null,null);}
        int qie = zhongStart;
        while(zhong[qie]!=qian[qianStart]){
            qie++;
        }
        int leftlen = qie-zhongStart;//这里别写成qianStart了
        System.out.println(leftlen);
        TreeNode cur = new TreeNode(qian[qianStart],null,null);
        cur.left = build(qian,qianStart+1,qianStart+leftlen,
                zhong,zhongStart,qie-1);
        cur.right = build(qian,qianStart+leftlen+1,qianEnd,
                zhong,qie+1,zhongEnd);
        return cur;
    }
}
