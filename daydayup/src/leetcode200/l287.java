package leetcode200;

public class l287 {
    //给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
    public int findDuplicate(int[] nums) {

        int fast=0;
        int slow=0;

        //所以这是个链表而且还有环,问题转化为l142
        do{
            fast=nums[fast];
            fast=nums[fast];
            slow = nums[slow];

        }while (fast!=slow);
        int slow2=0;
        while (slow2!=slow){
            slow2=nums[slow2];

            slow = nums[slow];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==slow2){//System.out.println(slow2);
                return slow2;//注意这里返回的是slow2 而 不是i
                //画图可知进入环的上一个就是重复的(为什么?你想啊有两个节点都指向了这个环的入口可不是重复了嘛
            }
        }

        return -1;
    }
}
