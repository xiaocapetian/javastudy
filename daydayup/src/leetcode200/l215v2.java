package leetcode200;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 底部有讲解，用了"快速排序"思想的“快速选择”,这个我理解了
 */
public class l215v2 {
    /**
     *
     * @param nums    求数组第k大的元素
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        return quickselect(numList,k);

    }
    private int quickselect(List<Integer> nums, int k){
        // 随机选择nums的某一位,作为基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));

        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();

        for (Integer num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }

        if(big.size() >=k){/*[重难]这里必须要>= , 若 = 也算包括*/
            return quickselect(big,k);
        }else if(big.size() +equal.size()>=k){/*[重难]这里必须要>=  若 = 也算包括*/
            return pivot;
        }else {
            return quickselect(small,k-big.size()-equal.size());
        }
    }
}
/*
 「快速选择」：设 N 为数组长度。根据快速排序原理，如果某次哨兵划分后，基准数的索引正好是 N−k ，则意味着它就是第 k 大的数字 。此时就可以直接返回它，无需继续递归下去了。
然而，对于包含大量重复元素的数组，每轮的哨兵划分都可能将数组划分为长度为 1 和 n−1 的两个部分，这种情况下快速排序的时间复杂度会退化至 O(N^2) 。
一种解决方案是使用「三路划分」，即每轮将数组划分为三个部分：小于、等于和大于基准数的所有元素。这样当发现第 k 大数字处在“等于基准数”的子数组中时，便可以直接返回该元素。
为了进一步提升算法的稳健性，我们采用随机选择的方式来选定基准数。

作者：Krahets
链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */