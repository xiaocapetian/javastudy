package leetcode300;

/**
 * 5.19二刷
 */
public class l376v2 {

    public int wiggleMaxLength(int[] nums) {

        if(nums.length==1)return 1;
        if(nums.length==2)return nums[0]==nums[1]?1:2;
        int left = 0;
        int mid = 1;
        while (mid<nums.length&&nums[mid]==nums[left]){
            mid++;
        }
        if(mid==nums.length){
            return 1;
        }
        int right = mid+1;
        int res =2;
        while (right<nums.length){
            if((nums[left]-nums[mid])*(nums[mid]-nums[right])<0){
                left =mid;
                mid =right;
                right++;
                res++;
            }else {
                mid =right;/*[易错]这句话别忘啦!!!*/
                right++;
            }
        }

        return res;
    }
}
