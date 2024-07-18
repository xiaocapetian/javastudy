package leetcode1000;

public class l1011 {
    /**
     * 大胆上二分查找
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            sum+= weights[i];
            max = Math.max(max,weights[i]);
        }
        int left = max;
        int right = sum;
        while (left<=right){
            int mid = (left+right)/2;
            int res = get(mid,weights);
//            if(res ==days){
//                return mid;
//            }else if(res<days){
            /*[易错]如果刚好== 也有可能还能再降低呢?
            * 所以直接算作大于就行,*/
            if(res<=days){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    private int get(int mid , int[] weights){
        int sum = 0;
        int count = 1;
        for(int i = 0;i<weights.length;i++){
            if(sum+weights[i]>mid){
                sum = weights[i];
                count++;
            }else {
                sum+=weights[i];
            }
        }
        return count;
    }
}
