package leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l101 {
    public boolean isSymmetric(TreeNode root) {
        //先自己写个层序遍历!  后来看了答案写出来了但是调试麻烦啊,而且速度及其慢
        if(root==null){return true;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();//对于每一层都有个list
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll!=null){//统一在这管理
                    list.add(poll.val);
                    //放左右子的时候就不用考虑是不是null了   ----即使是null也要给我放进去
                    queue.add(poll.left);//if(poll.left!=null)queue.add(poll.left);else{queue.add(null);}
                    queue.add(poll.right);//if(poll.right!=null)queue.add(poll.right);else{queue.add(null);}
                }else{
                    list.add(null);// ----即使是null也要给我放进去
                }
            }
            //System.out.println(list);

            for (int i = 0; i < list.size()/2; i++) {
                //如果是null,不能调get方法
                if(list.get(i)==null&&list.get(list.size()-1-i)==null){}
                else if(list.get(i)==null&&list.get(list.size()-1-i)!=null) return false;
                else if(list.get(i)!=null&&list.get(list.size()-1-i)==null) return false;//一个是null一个不是null
                else if(!list.get(i).equals(list.get(list.size()-1-i))){//或者不一样,当然返回错
                    return false;
                }
            }
        }
        return true;
    }


}
