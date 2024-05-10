package leetcode;

public class l27 {
//我真厉害!自己一遍写出来一遍过!
    //自己想的快慢指针,真潇洒! 我自己写的是快慢交换,实际上都不需要交换!
    /*总结的好啊:快指针寻找新数组所需要的元素,慢指针是新数组*/
    public int removeElement(int[] nums, int val) {
        int quick;
        int slow = 0;
        for (quick = 0; quick < nums.length; quick++) {
            if(nums[quick]!=val&&nums[slow]==val){
                int temp = nums[quick];
                nums[quick] = nums[slow];
                nums[slow] = temp;
            }
            if(nums[slow]!=val){slow++;}
        }
        return slow;
    }
    //改进实际上不要交换
    public int removeElement2(int[] nums, int val) {
        int quick;
        int slow = 0;
        for (quick = 0; quick < nums.length; quick++) {
            if(nums[quick]!=val){//只要quick找到了需要的值,慢指针所写的那个新数组就记录上
                nums[slow] = nums[quick];
                slow++;//slow只要记录了一个,就可以前进,slow看到了什么不重要,它只写不读!
            }
            //if(nums[slow]!=val){slow++;}
        }
        return slow;
    }
}
