package leetcode300;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class l373 {
    //超时的
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<List<Integer>>((o1, o2) -> {
            return o1.stream().reduce(0,Integer::sum)-o2.stream().reduce(0,Integer::sum);
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                priorityQueue.add(list);
            }
        }
        List<List<Integer>> res= new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
}
