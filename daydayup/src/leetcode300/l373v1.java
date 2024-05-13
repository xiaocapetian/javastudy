package leetcode300;

import java.util.ArrayList;
import java.util.List;

/**
 * 大佬说了,由于 nums1 和 nums2均已按升序排序，因此每个 nums1[i]参与构成的点序列也为升序排序，这引导我们使用「多路归并」来进行求解。l264就是多路归并
 * 自己尝试多路归并了,怎么还是超时了啊,,,,
 * 原因就在于这里判断最小值,用到是遍历啊,你说是不是很慢啊!
 * 看看v2,这里应该用优先队列来比较
 */
public class l373v1 {
    boolean flag = true;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length && !(flag = false)) return kSmallestPairs(nums2, nums1, k);
        duoluguibing(nums1,nums2,k);

        return res;
    }

    private void duoluguibing(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] zhizheng = new int[n];//代表每一位的指针
        int min = Integer.MAX_VALUE;
        while (true){
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(zhizheng[i]<nums2.length){
                    int point = nums1[i]+nums2[zhizheng[i]];
                    min = Math.min(min,point);
                }

            }
            for(int i = 0; i < n; i++){
                if(zhizheng[i]<nums2.length&&nums1[i]+nums2[zhizheng[i]]==min){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[zhizheng[i]]);
                    res.add(list);
                    if(res.size()==k){return;}
                    zhizheng[i] +=1;
                    break;
                }
            }
        }
    }
}
//作者：宫水三叶
//链接：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/1209848/gong-shui-san-xie-duo-lu-gui-bing-yun-yo-pgw5/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。