package leetcode300;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**「多路归并」+ 优先队列
 * 放进优先队列中!!!
 */
public class l373v2 {
    boolean flag = true;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //if (nums1.length > nums2.length && !(flag = false)) return kSmallestPairs(nums2, nums1, k);
        duoluguibing(nums1,nums2,k);

        return res;
    }

    private void duoluguibing(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] zhizheng = new int[n];//代表每一位的指针
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            //咱的优先队列放的是索引下标噢---这样方便取出来之后放下一位,不然你咋知道它的地址是哪?
            //所谓由索引知值易,由值知地址难啊!
            int h1 = nums1[o1[0]]+nums2[o1[1]];
            int h2 = nums1[o2[0]]+nums2[o2[1]];
            return h1-h2;
        });
        for(int i = 0; i < n; i++){
            int[] newp = new int[]{i,0};
            priorityQueue.add(newp);
        }
        while (res.size()<k){
            int[] poll = priorityQueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            res.add(list);
            if(poll[1]+1<nums2.length){
                int[] newp = new int[]{poll[0],poll[1]+1};
                priorityQueue.add(newp);
            }

        }

    }
}
