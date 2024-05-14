package leetcode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.TreeNode.printBinaryTreeStructure;

/**
 * 这道题写了好久好久哦
 */
public class l95 {
    public static void main(String[] args) {
        l95 s = new l95();
        List<TreeNode> trees = s.getTrees(3, 1);

        for (TreeNode tree : trees) {
            printBinaryTreeStructure(tree);
            System.out.println("========");
        }
    }
    /**
     * @param n 给你一个整数 n
     * @return 请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     */
    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> res = getTrees(n,1);
        return res;
    }

    private List<TreeNode> getTrees(int n,int offsetval) {
        List<TreeNode> list = new ArrayList<>();
        if (n==0)return list;
        if(n==1){
            TreeNode treeNode = new TreeNode(offsetval);
            list.add(treeNode);
            return list;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            //TreeNode treeNode = new TreeNode(i+offsetval-1);
            /*[易错]👆这道题我犯了一个什么大错误啊?!?我怎么能在这里指定一个treeNode 呢?后面有一个for循环要不断返回的呀!肯定是不同的呀*/
            System.out.println("left = getTrees("+(i - 1)+","+offsetval+")");
            System.out.println("right = getTrees("+(n - i)+","+(i+offsetval)+")");
            List<TreeNode> left = getTrees(i - 1, offsetval);/*[重难,易错]   i - 1, offsetval */
            List<TreeNode> right = getTrees(n - i, i+offsetval);/* n - i, i+offsetval */
            System.out.println("left");
            for (TreeNode node : left) {
                printBinaryTreeStructure(node);
            }
            System.out.println("right");
            for (TreeNode node : right) {
                printBinaryTreeStructure(node);
            }
            if(left.size()==0){

                for (int i2 = 0; i2 < right.size(); i2++) {
                    TreeNode treeNode = new TreeNode(i+offsetval-1);/*[重难,易错],父节点应该是i+offsetval-1*/
                    treeNode.left = null;
                    treeNode.right = right.get(i2);
                    res.add(treeNode);
                    //就是说每一个往里塞的值都应该是一个新的treeNode呀!!!
                }
            }
            if(right.size()==0){

                for (int i1 = 0; i1 < left.size(); i1++) {
                    TreeNode treeNode = new TreeNode(i+offsetval-1);
                    treeNode.left = left.get(i1);
                    treeNode.right =null;
                    res.add(treeNode);
                }
            }
            for (int i1 = 0; i1 < left.size(); i1++) {
                for (int i2 = 0; i2 < right.size(); i2++) {
                    TreeNode treeNode = new TreeNode(i+offsetval-1);
                    treeNode.left = left.get(i1);
                    treeNode.right = right.get(i2);
                    res.add(treeNode);
                }
            }
            //treeNode.printBinaryTreeStructure(treeNode);
            //System.out.println("~~~~");

        }
        return res;
    }

}
