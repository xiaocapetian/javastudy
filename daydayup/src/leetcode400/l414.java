package leetcode400;

public class l414 {

    public static void main(String[] args) {
        l414 s = new l414();
        int[] nums = new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
        s.thirdMax(nums);
    }

    /**
     * 整的太复杂了我抄
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean max1b = false;
        boolean max2b = false;
        boolean max3b = false;
        for (int num : nums) {
            if (num > max||((!max1b))) {
                int tmp = max;
                max = num;
                if (max1b) {
                    //min1之前没被改过

                    int tmp2 = max2;
                    max2 = tmp;
                    if (max2b) {
                        //min2之前没改过
                        max3 = tmp2;
                        max3b = true;
                    }
                    max2b = true;

                }
                max1b = true;
            } else if (num < max&&(num > max2||!max2b)) {
                int tmp2 = max2;
                max2 = num;
                if (max2b) {
                    //min2之前没改过
                    max3 = tmp2;
                    max3b = true;
                }
                max2b = true;
            } else if (num < max2&&(num > max3||!max3b)) {
                max3 = num;
                max3b = true;
            }
        }
        if(max3b){
            return max3;
        }else return max;
    }
}
