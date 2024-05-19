package leetcode200;

public class l280v1 {
    //
    public void wiggleSort(int[] nums) {


        for (int i = 0; i < nums.length-1; i++) {
            //不要往2个值方面去想,往一个值的方面想,对于i
            //如果i是奇数,应该要符合 低高低吧?
            //前一个低高已经符合了,如果下一个更高, 3 5 7,那么交换下两个 由于下一个更高,肯定是高的不用担心破坏前面
            if(i%2==1){
                if(nums[i]<nums[i+1]){
                    swap(i,i+1,nums);
                }
            }else {
                //高低高  如果下一个更低,交换
                if(nums[i] >nums[i+1]){
                    swap(i,i+1,nums);
                }
            }

        }

    }


    private void swap(int i1, int i2, int[] nums) {
        int swap = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] =swap;
    }
}
