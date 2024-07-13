package leetcode600;

import java.util.*;

public class l658 {
    /**自己想的思路，用一个栈
     * 把List<Integer>换成Deque<Integer>确实快一点点，但是还是慢
     * （咱的还是复杂，瞧瞧v1人家弄的，简单些！
     * @param arr 给定一个 排序好 的数组 arr
     * @param k
     * @param x 从数组中找到最靠近 x（两数之差最小）的 k 个数。
     * @return  回的结果必须要是按升序排好的
     * 距离x最近，若一样近选小的那个
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Deque<Integer> deque = new LinkedList<>();
        //List<Integer> res=new ArrayList<>();
        Stack<Integer> stack =new Stack<>();
        int i = 0;
        for(;i<arr.length&&arr[i]<=x;i++){
            stack.add(arr[i]);
        }
        int count = 0;
        while (count<k){
            if(stack.isEmpty()){
                deque.addLast(arr[i]);
                //res.add(arr[i]);
                i++;

            }else if(i>=arr.length){
                deque.addFirst(stack.pop());
                //res.add(stack.pop());
            }else {
                int s1 = stack.peek();
                int s2 = arr[i];
                if(x-s1<=s2-x){
                    deque.addFirst(stack.pop());
                }else {
                    deque.addLast(arr[i]);
                    i++;
                }
            }

            count++;
        }
        //Collections.sort(res);
        List<Integer> res=new ArrayList<>(deque);
return res;

    }
}
