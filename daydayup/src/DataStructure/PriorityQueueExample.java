package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
//优先队列!  我感觉优先队列就是个自动排序的队列,,,   优先指的是👇
//PriorityQueue根据元素的优先级来对元素进行排序，并确保具有最高（或最低）优先级的元素始终位于队列的前面。
public class PriorityQueueExample {
    public static void main(String[] args) {
        /*`PriorityQueue` 在 Java 中是基于 🙂堆🙂 实现的。
        具体来说，它是基于 🙂优先级堆🙂 实现的，通常是一个二叉堆（Binary Heap）。
        二叉堆是一种完全二叉树，它可以被存储在数组中，并且满足堆的性质：
        对于每个节点 `i`,父节点的值小于或等于其子节点的值（最小堆/小顶堆）或父节点的值大于或等于其子节点的值（最大堆/大顶堆）。
        `PriorityQueue` 默认 是 小顶堆。*/
        PriorityQueue<Integer> pqu1 = new PriorityQueue<>((o1, o2) ->o2-o1);//这个叫大顶堆
        PriorityQueue<Integer> pqu2 = new PriorityQueue<>((o1, o2) ->o1-o2);//这个叫小顶堆(默认)
        /*
        `PriorityQueue` 使用堆的数据结构来维护元素的顺序，使得插入和删除操作的时间复杂度分别为 O(log n)，其中 n 是队列的大小。
        这使得 `PriorityQueue` 非常适合需要按优先级处理元素的场景，比如任务调度、事件处理等。
        * */
        // 创建一个优先队列，元素按照自然顺序进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 向优先队列中添加元素
        priorityQueue.offer(5);priorityQueue.offer(3);priorityQueue.offer(8);priorityQueue.offer(1);

        // 输出队列中的元素，注意输出顺序
        //System.out.println(priorityQueue);//[1, 3, 8, 5]
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
            /*是poll(),而不是pop()*/
            //1,3,5,8,
        }

        System.out.println("============================");
        /*比较器*/
        // 创建一个优先队列，🙂比较器🙂 指定排序规则:根据第二个元素的大小降序排列
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1]-pair1[1];
            }
        });
        // 向优先队列中添加一些元素
        pq.offer(new int[]{1, 10});
        pq.offer(new int[]{2, 5});
        pq.offer(new int[]{3, 8});

        // 弹出优先队列中的元素
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            System.out.println("第一个元素：" + pair[0] + ", 第二个元素：" + pair[1]);
        }
    }

}
//例题
//l451