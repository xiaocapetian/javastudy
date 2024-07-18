package leetcode800;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class l870v1 {
    /**
     *执行的也不快啊...
     * @param nums1 给定两个长度相等的数组 nums1 和 nums2，
     * @param nums2 nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
     * @return 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
     */
    /*[重难]一种数据结构,可以找到比他大的最小值,treeset和treeMap可以*/
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        //treeMap.ceilingEntry()
        //treeSet.ceiling()
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            treeMap.put(nums1[i],treeMap.getOrDefault(nums1[i],0) + 1 );
        }
        for (int i = 0; i < nums2.length; i++) {
            Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.ceilingEntry(nums2[i]+1);//返回大于或等于它的最小元素
            if(integerIntegerEntry==null){
                Map.Entry<Integer, Integer> minEntry = treeMap.firstEntry();
                if(minEntry.getValue()-1>0){
                    treeMap.put(minEntry.getKey(),minEntry.getValue()-1);
                }else {
                    treeMap.remove(minEntry.getKey());
                }
                res[i] = minEntry.getKey();
            }else {
                if(integerIntegerEntry.getValue()-1>0){
                    treeMap.put(integerIntegerEntry.getKey(),integerIntegerEntry.getValue()-1);
                }else {
                    treeMap.remove(integerIntegerEntry.getKey());
                }
                res[i] = integerIntegerEntry.getKey();
            }
        }

        return res;

    }
}
