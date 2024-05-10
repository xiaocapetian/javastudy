package leetcode2000;

import java.util.ArrayList;
import java.util.List;

public class l2476v2 {
    //作者：力扣官方题解
//链接：https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/
// solutions/2645284/er-cha-sou-suo-shu-zui-jin-jie-dian-cha-vp6p2/
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<Integer>();
        dfs(root, arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int val : queries) {// 初始化最大值和最小值为 -1
            int maxVal = -1, minVal = -1;//二分查找左指针最后的位置
            int idx = binarySearch(arr, val);// 在升序数组 arr 中二分查找查询值 val 的位置，返回左指针最后的位置
            if (idx != arr.size()) {//如果返回的这个left不是arr.size(),说明要找的元素不在数组的外右面
                maxVal = arr.get(idx);//要找的元素肯定在left的左边或者等于left__为什么呢?因为二分查找要么找到了,要么left跑到要找的左边去了
                if (arr.get(idx) == val) {//说明找到了
                    minVal = val;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(minVal);
                    list.add(maxVal);
                    res.add(list);
                    continue;
                }
            }
            if (idx > 0) {// 如果左指针位置大于 0，说明找到了目标值的左边界
                minVal = arr.get(idx - 1);// 目标值的左边界即为左指针位置减 1 的元素值
            }
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(minVal);
            list2.add(maxVal);
            res.add(list2);
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    public int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}



