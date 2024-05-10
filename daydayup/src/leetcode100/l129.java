package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己写的,可以使用,用的是字符串List<String>,就是慢呗
 * [重难点],不能随便加,因为可能有长度不一致540和52你能在这一位就加吗?所以要一个list
 */
public class l129 {
    public int sumNumbers(TreeNode root) {

        List<String> res = getSum(root);
        int sum=0;
        for (int i = 0; i < res.size(); i++) {
            sum+=Integer.parseInt(res.get(i));
        }
        return sum;
    }
    public List<String> getSum(TreeNode cur){
        if(cur.left==null&&cur.right==null){
            List<String> res = new ArrayList<>();
            res.add(cur.val+"");
            return res;
        }
        List<String> res = new ArrayList<>();
        if(cur.left!=null){
            //int leftres = getSum(cur.left);
            List<String> leftres = getSum(cur.left);
            for (String leftre : leftres) {
                res.add(cur.val + leftre);
            }
        }
        if(cur.right!=null){
            //int leftres = getSum(cur.left);
            List<String> rightres = getSum(cur.right);
            for (String rightre : rightres) {
                res.add(cur.val + rightre);
            }
        }
        return res;


    }
}
