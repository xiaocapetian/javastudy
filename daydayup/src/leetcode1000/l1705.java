package leetcode1000;

import java.util.PriorityQueue;

/**
 * 华为面面
 * 面完几分钟就做出来了
 * 但是超时了
 *
 * 思路
 */
public class l1705 {
    public int eatenApples(int[] apples, int[] days) {
//List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        for(int i = 0;i<apples[0];i++){
            //list.add(days[0]);
            pq.add(days[0]);
        }
        int day=1;

        int num=0;
        while (!pq.isEmpty()||day<apples.length){

            if(!pq.isEmpty()){
                Integer poll = pq.poll();
                if(poll>=day){num++;}
                while(!pq.isEmpty()&&poll<day){
                    //System.out.println("poll="+poll);
                    poll = pq.poll();
                    if(poll>=day){num++;}
                }
            }
            //今天吃过了

            //pq.forEach(integer -> {integer--;});
            //加的是明天的
            if(day<apples.length){
                for(int i = 0;i<apples[day];i++){
                    //list.add(days[0]);
                    pq.add(days[day]+day);
                }
            }
            //System.out.println(pq+"day"+day);
            //if(haseat&&!pq.isEmpty()){}
            day++;/*[易错]这里就不需要再如果什么什么再day++了*/
        }
        return num;
    }
}
