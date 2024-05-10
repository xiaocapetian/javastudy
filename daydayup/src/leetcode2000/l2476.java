package leetcode2000;

import java.util.ArrayList;
import java.util.List;

public class l2476 {
    //自己写的应该是对的,但超时了,我抄
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            list.add(-1);
            find(root, queries.get(i),list);
            res.add(list);
        }
        return res;

    }
    public void find(TreeNode root,Integer query,List<Integer> list){
        if(root==null)return;
        if(root.val==query){
            list.set(0,root.val);
            list.set(1,root.val);
        }else if(root.val<query){
            list.set(0,root.val);
            find(root.right,query,list);
        }else {
            list.set(1,root.val);
            find(root.left,query,list);
        }


    }
}
