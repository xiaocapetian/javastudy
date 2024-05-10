package leetcode100;

public class l189 {

    //不使用额外数组,找规律了啊
    //可以两次翻转数组
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        for(int i = 0;i<nums.length/2;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
        for(int i = 0;i<k/2;i++){
            int temp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-i-1] = temp;
        }
        for(int i = 0;i<(nums.length-k)/2;i++){
            int temp = nums[i+k];
            nums[i+k] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
    }
    //使用额外数组
    public void rotate2(int[] nums, int k) {
        k = k%nums.length;
        int right = nums.length-k;
        int[] nums2 = new int[nums.length];
        for(int i = 0;i<k;i++){
            nums2[i] = nums[right+i];
        }
        for(int i = k;i<nums.length;i++){
            nums2[i] = nums[i-k];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = nums2[i];
        }
    }
    //使用额外数组
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
            //思考i = 0的点会移动和到哪一点
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

}
