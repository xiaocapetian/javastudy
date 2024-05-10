package leetcode;

public class l55 {
    public boolean canJump(int[] nums) {
//自己想的思路，找0到往前看能不能跳
        int item=0;
        while (item!= nums.length){
            if(nums[item]==0) {
                int lookBack = item;
                while (nums[lookBack]<=item-lookBack){
                    if(lookBack==0)return false;
                    lookBack--;
                    //注意,这个必须先判断再--,如果已经到0了就不用--了直接判false吧!
                    }
            }
            item++;
        }
        return true;
    }

}
