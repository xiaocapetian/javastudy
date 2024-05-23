package leetcode900;

import java.util.LinkedList;
import java.util.Queue;

public class l933 {
    /**
     * 这题的关键是要用  Queue<Integer> queue队列数据结构
     */
    class RecentCounter {

        Queue<Integer> queue;

        //int preItem;没必要这样呀 用队列过期就扔出去了
        public RecentCounter() {
            queue = new LinkedList<>();
            //preItem= 0;
        }

        //返回过去 3000 毫秒内发生的所有请求数（包括新请求）
        public int ping(int t) {

            while (!queue.isEmpty()&&queue.peek()<t-3000){
                queue.poll();
            }
            queue.add(t);
            return queue.size();

        }
    }
}
