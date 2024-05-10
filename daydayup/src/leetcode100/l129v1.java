package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己想了个这个,其实和v0一样,但是这个就快多了
 */
public class l129v1 {
    int res=0;
    public int sumNumbers(TreeNode root) {
        find(root);
        return res;
    }
    public List<Integer> find(TreeNode cur){
        if(cur.left==null&&cur.right==null){
            res+=cur.val;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> list = new ArrayList<>();
        if(cur.left!=null){
            List<Integer> wei = find(cur.left);
            for (Integer integer : wei) {
                list.add(integer + 1);
            }

        }
        if(cur.right!=null){
            List<Integer> wei = find(cur.right);
            for (Integer integer : wei) {
                list.add(integer + 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            res+=cur.val*Math.pow(10,list.get(i));
        }
        return list;
    }
}
