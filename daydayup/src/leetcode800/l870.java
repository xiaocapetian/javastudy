package leetcode800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l870 {
    /**
     * 是对的,但是超级慢
     * 基本思路:显然，对于任意一个 t=nums2[i] 而言，我们应当在候选集合中选择比其大的最小数，若不存在这样的数字，则选择候选集合中的最小值。 ===没有问题,我也知道
     * @param nums1 给定两个长度相等的数组 nums1 和 nums2，
     * @param nums2 nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
     * @return 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {

        //Arrays.sort(nums1);
        //Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < nums2.length; i++) {
            int wei = find(list, nums2[i]);
            if(wei<list.size()){
                res[i] = list.remove(wei);
            }else {
                res[i] = list.remove(0);
            }
        }
        return res;
    }

    private int find(List<Integer> list, int i) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == i) {  /*[易错]二分查找 如果找到一群相等的咋办?没考虑啊!! */
                while (mid+1<list.size() && list.get(mid).equals(list.get(mid+1))) {
                    mid++;
                }
                return mid+1;}//👈注意哦!!!!必须取一群最大值的最右
            else if (list.get(mid) < i) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
