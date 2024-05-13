package leetcode200;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**简单版👇
 * 使用优先队列：      一定要去学v1!!!!
 *
 * 1.起始先将最小丑数 111 放入队列
 * 2.每次从队列取出最小值 xxx，然后将 xxx 所对应的丑数 2x2x2x、3x3x3x 和 5x5x5x 进行入队。
 * 3.对步骤 2 循环多次，第 nnn 次出队的值即是答案。
 *
 * 作者：宫水三叶
 * 链接：https://leetcode.cn/problems/ugly-number-ii/solutions/714340/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class l264 {
    public int nthUglyNumber(int n) {

        PriorityQueue<Integer> priorityQueue =new PriorityQueue<>();
        int count = 0;
        priorityQueue.add(1);
        Integer poll=0;
        Set<Integer> set = new HashSet<>();
        while (n>count){
            poll = priorityQueue.poll();
            if(!set.contains(poll*2)&&poll<Integer.MAX_VALUE/2) {priorityQueue.add(poll*2);set.add(poll*2);}
            if(!set.contains(poll*3)&&poll<Integer.MAX_VALUE/3) {priorityQueue.add(poll*3);set.add(poll*3);}
            if(!set.contains(poll*5)&&poll<Integer.MAX_VALUE/5) {priorityQueue.add(poll*5);set.add(poll*5);}
            count++;
            System.out.println(poll);
        }
        return poll;
    }
}

