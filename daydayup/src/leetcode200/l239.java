package leetcode200;

import java.util.Deque;
import java.util.LinkedList;

/**本题v0v1单调队列,v2优先队列
 * //这个真的高级啊在看这个，这么久了早忘了,看v1容易理解一点~
 * //单调队列
 */
public class l239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        l239 s = new l239();
        s.maxSlidingWindow(nums,k);
    }

    /**
     *
     * @param nums 给你一个整数数组 nums，
     * @param k 有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * @return 返回 滑动窗口中的最大值 。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if (nums.length == 1) {
            return nums;
        }
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
            //myQueue.sout();
        }
        res[num++]=myQueue.peek();
        for (int i = k; i < nums.length; i++){
            //加一个
            myQueue.poll(nums[i-k]);
            //再删一个
            myQueue.add(nums[i]);
            res[num++]=myQueue.peek();
            //myQueue.sout();
        }
        return res;
    }

    /**
     * 我的这个单调队列，是单减的，越前越大，
     *
     */
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素
        //窗口要滑动了,丢一个元素,如果这个元素不是最大值,那在队列已经早就被删掉了,不用管,若窗口滑动的元素是最大值,那就要把最大值弹出了
        // 比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val){
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        //添加元素
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出，再大于，再弹出，（保证队列是单调的，只单减）
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val){
            while (!deque.isEmpty()&&val>deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
        }
        //队列队顶元素始终为最大值
        int peek(){
            return deque.peek();
        }
        void sout(){
            System.out.println(deque);
        }
    }
}
