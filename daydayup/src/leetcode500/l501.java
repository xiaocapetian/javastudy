package leetcode500;

import java.util.*;

public class l501 {
//我自己写的和随想录思路一致!!!我很棒!!!
    TreeNode pre;
    int count = 0;
    int max = 0;

    //我本来是把public void inorder(TreeNode root,int count,int max,List<Integer> res)
    //把count和max当作成员变量来回传的,C老师说要把count和max设成全局变量
    //为什么呢?因为既然我试图max = count;等修改max的值,但是我不返回怎么能把变量给改了呢?
    //不要忘了java的函数的方法参数是按值传递,不是按引用传递!
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int[] ints = res.stream().mapToInt(value -> value).toArray();
        return ints;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        if (pre != null && root.val == pre.val) {
            count++;
        } else count = 1;
        pre = root;

        if (count == max) {
            res.add(root.val);
        }
        if (count > max) {
            res.clear();
            res.add(root.val);
            max = count;
        }
       /*上面是我自己写的,下面是C老师要我调换位置,其实都行
       if(count>max){
           res.clear();
           res.add(root.val);
           max = count;
       }
       else if(count==max){
           res.add(root.val);
       }*/
        inorder(root.right, res);
    }
}
