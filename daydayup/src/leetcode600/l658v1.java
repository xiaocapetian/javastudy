package leetcode600;

import java.util.ArrayList;
import java.util.List;

public class l658v1 {
    /**说明你人的思想不能太僵化，活跃一点，让你取最近k个元素你就真去找吗，你就不能从两侧删吗
你弄个双指针直接两侧删多带劲啊！
     * @param arr 给定一个 排序好 的数组 arr
     * @param k
     * @param x 从数组中找到最靠近 x（两数之差最小）的 k 个数。
     * @return  回的结果必须要是按升序排好的
     * 距离x最近，若一样近选小的那个
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length-1;
        int count= 0;
        while (count<arr.length-k){
            if(x-arr[left]<=arr[right]-x){
                right--;
            }else {
                left++;
            }
            count++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = left;i<=right;i++){
            res.add(arr[i]);
        }
        return res;
    }
}
