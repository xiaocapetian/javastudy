package leetcode200;

import java.util.PriorityQueue;

public class l295 {
    //我感觉优先队列就是个自动排序的队列,,,
/*这题是怎么想到优先队列的呢?
    优先队列 可神奇了,放进去的元素自动给你排序了
    你只要建2个优先队列,优先队列就能给你排序了*/
}
class MedianFinder {

    PriorityQueue<Integer> pqMin;
    PriorityQueue<Integer> pqMax;
    public MedianFinder() {
        pqMin = new PriorityQueue<>((o1, o2) ->o2-o1);//这个叫大顶堆啊
        pqMax = new PriorityQueue<>((o1, o2) ->o1-o2);//这个叫小顶堆啊
        //  5,3,1 降序
        //7,9升序
    }

    public void addNum(int num) {
        //保证.size() 要么min==max,要么min==max+1
        if(pqMin.size()==0|| pqMin.peek()>num){
            pqMin.add(num);
        }else {
            pqMax.add(num);
        }
        //System.out.println(priorityQueueMin);
        //System.out.println(priorityQueueMax);
        if(pqMin.size()- pqMax.size()>1){
            pqMax.add(pqMin.poll());
        }else if(pqMax.size()> pqMin.size()){
            pqMin.add(pqMax.poll());
        }

    }

    public double findMedian() {
        if(pqMin.size()== pqMax.size()){
            return (pqMin.peek()+ pqMax.peek())/2.0;}
        else {//一定是if(pqMin.size()> pqMax.size())
            return pqMin.peek();
        }
        //return -1;
    }
}
