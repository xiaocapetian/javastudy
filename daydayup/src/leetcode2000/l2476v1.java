package leetcode2000;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class l2476v1 {
    //把二叉搜索树的内容全拿出来放进数组,然后写一个二分查找来查
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root,arr);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> list = new ArrayList<>();
            int maxVal = -1, minVal = -1;

            //find(arr, query,list);

            res.add(list);
        }
        return res;
    }

    /**
     * 力扣官方写的二分查找,只返回最后left的位置,这样写的话那上面的就要细写注释
     * @param arr
     * @param query
     * @return
     */
    private Integer find2(List<Integer> arr, Integer query){
        int left = 0;
        int right = arr.size()-1;
        //int mid=-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            //这里真的要用Objects.equals(arr.get(mid), query))不然会错
            if(Objects.equals(arr.get(mid), query)){}
            else if(arr.get(mid) >query){
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }
        return left;
    }
    /**
     * 我自己写的二分查找,
     */
    private void find(List<Integer> arr, Integer query, List<Integer> list) {
        int left = 0;
        int right = arr.size()-1;
        //int mid=-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            //这里真的要用Objects.equals(arr.get(mid), query))不然会错
            if(Objects.equals(arr.get(mid), query)){list.set(0,arr.get(mid));list.set(1,arr.get(mid));return;}
            else if(arr.get(mid) >query){
                right = mid - 1;
                list.set(1,arr.get(mid));
            }
            else {
                left = mid +1;
                list.set(0,arr.get(mid));
            }
        }

        //list.set(0,arr.get(mid));
        //list.set(1,arr.get(mid));
        //return;
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if(root==null)return;
        dfs(root.left,arr);
        arr.add(root.val);
        dfs(root.right,arr);
    }
}
