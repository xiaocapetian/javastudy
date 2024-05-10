package leetcode400;

import java.util.ArrayList;
import java.util.List;

public class l437 {
    //递归法
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        List<Integer> path = new ArrayList<>();
        find(root, targetSum,0,path);

        return count;
    }
    public void find(TreeNode node, int targetSum,int currSum,List<Integer> path){
        if(node==null){return; }
        currSum =currSum+ node.val;
        path.add(node.val);
        System.out.println(path+","+currSum);
        // 检查路径中是否有符合要求的和
        int temp = currSum;

//从前向后,从头开始依次减去
        for (Integer integer : path) {
            if (temp == targetSum) {
                count++;
            }
            temp -= integer;
            System.out.println("temp减去"+integer+" ,temp==" + temp);
        }

        find(node.left,targetSum,currSum,path);
        find(node.right,targetSum,currSum,path);
// 回溯，移除当前节点
        path.remove(path.size() - 1);
    }
}
//这是个递归,是从头开始取的,但是下面会算temp,挨个减去
/*
[10],10
[10, 5],15
[10, 5, 3],18
[10, 5, 3, 3],21
[10, 5, 3, -2],16
[10, 5, 2],17
[10, 5, 2, 1],18
[10, -3],7
[10, -3, 11],18
*/
//temp的变化(注意是先比再减所以真实比的会多一个一项不减的,少一个全减完的0)
/*[10],10
temp-=10 ,temp==0
[10, 5],15
temp-=10 ,temp==5
temp-=5 ,temp==0
[10, 5, 3],18
temp-=10 ,temp==8
temp-=5 ,temp==3
temp-=3 ,temp==0
[10, 5, 3, 3],21
temp-=10 ,temp==11
temp-=5 ,temp==6
temp-=3 ,temp==3
temp-=3 ,temp==0
[10, 5, 3, -2],16
temp-=10 ,temp==6
temp-=5 ,temp==1
temp-=3 ,temp==-2
temp-=-2 ,temp==0
[10, 5, 2],17
temp-=10 ,temp==7
temp-=5 ,temp==2
temp-=2 ,temp==0
[10, 5, 2, 1],18
temp-=10 ,temp==8
temp-=5 ,temp==3
temp-=2 ,temp==1
temp-=1 ,temp==0
[10, -3],7
temp-=10 ,temp==-3
temp-=-3 ,temp==0
[10, -3, 11],18
temp-=10 ,temp==8
temp-=-3 ,temp==11
temp-=11 ,temp==0*/