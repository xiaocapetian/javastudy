package leetcode800;

import java.util.ArrayList;
import java.util.List;
/**
 * 看到这道题想到什么呀?l95,
 * 从上往下想,简单!
 * 比如从5->7别想着在5的基础上在叶子节点加,
 * 而是从顶端考虑
 */
public class l894 {
    public List<TreeNode> allPossibleFBT(int n) {

        if(n==1){
            List<TreeNode> res = new ArrayList<>();
            TreeNode treeNode = new TreeNode(0);
            res.add(treeNode);
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = 1;i<=n-2;i+=2){

            List<TreeNode> leftlist = allPossibleFBT(i);
            List<TreeNode> rightlist = allPossibleFBT(n-1-i);
            for (int i1 = 0; i1 < leftlist.size(); i1++) {
                for (int i2 = 0; i2 < rightlist.size(); i2++) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = leftlist.get(i1);
                    treeNode.right = rightlist.get(i2);
                    res.add(treeNode);
                }
            }

        }
        return res;
    }
}
