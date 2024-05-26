package leetcode300;

/**
 * 桶排序
 */
public class l324v1 {
    public void wiggleSort(int[] nums) {

        //数的范围5000所以准备5000个桶
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int item=5000;
        //System.out.println(Arrays.toString(bucket));
        for(int  i = 1;i<nums.length;i+=2){
            while (bucket[item]==0){
                item--;
            }
            nums[i] = item;
            bucket[item]--;
        }
        for(int  i = 0;i<nums.length;i+=2){
            while (bucket[item]==0){
                item--;
            }
            //nums[i] = bucket[item];
            nums[i] = item;
            bucket[item]--;
        }

    }
    /**
     * 这里特别注意,这样子遇到少数案例是错的. 比如 4 5 5 6 小的:4 5 大的:5 6
     * 那4 5 5 6 排出来5和5相遇了,小的的最后一位和大的最前一位在数值上相邻,且排出来也可能相邻
     * 那怎么办?
     * 反着排
     * 5 6 4 5
     * 让小的的后面和大的的前面错开
     * 画个图更容易理解了 4 5 5 5 6 6
     * 两个桶都从高往低的话是 相邻两个都向相距3位
     * 两个桶都从第往高的话,大桶往校桶跳的时候相距2位,可能相同的值碰到
     */
    public void wiggleSortxx(int[] nums) {

        //数的范围5000所以准备5000个桶
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int item=0;
        //System.out.println(Arrays.toString(bucket));
        for(int  i = 0;i<nums.length;i+=2){
            while (bucket[item]==0){
                item++;
            }
            //nums[i] = bucket[item];
            nums[i] = item;
            bucket[item]--;
        }
        for(int  i = 1;i<nums.length;i+=2){
            while (bucket[item]==0){
                item++;
            }
            nums[i] = item;
            bucket[item]--;
        }
    }
}
