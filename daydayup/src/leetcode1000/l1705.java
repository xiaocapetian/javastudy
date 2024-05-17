package leetcode1000;

import java.util.PriorityQueue;

/**
 * 华为面面
 * 面完几分钟就做出来了
 * 但是超时了
 * <p>
 * 思路
 */
public class l1705 {
    /**
     * 把v2整理了一下,不用那么麻烦必须提前把第二天的摆上来了,因为循环停止的条件是或,要么队列没空,要么张果子的时间还有
     * 然后判断day++也是每天都要++
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        //a[0]代表哪天过期,a[1]代表有几个
        int day = 0;
        int num = 0;
        while (!pq.isEmpty() || day < apples.length) {

            //今天成熟的果子
            if (day < apples.length) {
                //明天一共成熟了apples[day]个果子,都是days[day]+day时过期,
                int[] today = new int[]{days[day] + day, apples[day]};
                pq.add(today);
            }
            if (!pq.isEmpty()) {
                int[] poll = pq.poll();
                if (poll[0] > day) {
                    num++;
                    poll[1]--;
                    if (poll[1] > 0) {
                        pq.add(poll);
                    }
                }//如果推出来的这个没过期,吃掉,num++;
                //而如果推出来的这个过期了,那就继续往外推
                while (!pq.isEmpty() && poll[0] <= day) {
                    //System.out.println("poll="+poll);
                    poll = pq.poll();
                    if (poll[0] > day) {
                        num++;
                        poll[1]--;
                        if (poll[1] > 0) {
                            pq.add(poll);
                        }
                    }//如果有一个是没过期的,吃掉,num++;
                }
            }
            day++;/*[易错]这里就不需要再如果什么什么再day++了*/
        }
        return num;
    }

    /**
     * 把改成int[]来同时存过期时间和数量,而不是有多少数量就存多少 ,这下不超时了,虽然也不快
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApplesV2(int[] apples, int[] days) {
//List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        //a[0]代表哪天过期,a[1]代表有几个

        int[] day0 = new int[]{days[0], apples[0]};
        pq.add(day0);
        int day = 1;

        int num = 0;
        while (!pq.isEmpty() || day < apples.length) {

            if (!pq.isEmpty()) {
                int[] poll = pq.poll();
                if (poll[0] >= day) {
                    num++;
                    poll[1]--;
                    if (poll[1] > 0) {
                        pq.add(poll);
                    }
                }//如果推出来的这个没过期,吃掉,num++;
                //而如果推出来的这个过期了,那就继续往外推
                while (!pq.isEmpty() && poll[0] < day) {
                    //System.out.println("poll="+poll);
                    poll = pq.poll();
                    if (poll[0] >= day) {
                        num++;
                        poll[1]--;
                        if (poll[1] > 0) {
                            pq.add(poll);
                        }
                    }//如果有一个是没过期的,吃掉,num++;
                }
            }
            //今天成熟的果子已经算过了,今天也吃过了

            //pq.forEach(integer -> {integer--;});
            //加的是明天的
            //把明天会成熟的果子今天就加进来
            if (day < apples.length) {
                //明天一共成熟了apples[day]个果子,都是days[day]+day后过期,
                int[] tomorrow = new int[]{days[day] + day, apples[day]};
                pq.add(tomorrow);
            }
            //System.out.println(pq+"day"+day);
            //if(haseat&&!pq.isEmpty()){}
            day++;/*[易错]这里就不需要再如果什么什么再day++了*/
        }
        return num;
    }

    /**
     * 最初的超时版本 ,最开始题没看清楚,以为吃不上就直接饿死了,其实吃不上不吃也是可以的,所以循环停止的条件是或,要么队列没空,要么长果子的时间还有
     * 所以没必要像这样把明天结的果子今天就加到队列里
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApplesV1(int[] apples, int[] days) {
//List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < apples[0]; i++) {
            //list.add(days[0]);
            pq.add(days[0]);//优先队列里存的是过期的时间
        }
        int day = 1;

        int num = 0;
        while (!pq.isEmpty() || day < apples.length) {

            if (!pq.isEmpty()) {
                Integer poll = pq.poll();
                if (poll >= day) {
                    num++;
                }//如果推出来的这个没过期,吃掉,num++;
                //而如果推出来的这个过期了,那就继续往外推
                while (!pq.isEmpty() && poll < day) {
                    //System.out.println("poll="+poll);
                    poll = pq.poll();
                    if (poll >= day) {
                        num++;
                    }//如果有一个是没过期的,吃掉,num++;
                }
            }
            //今天成熟的果子已经算过了,今天也吃过了

            //pq.forEach(integer -> {integer--;});
            //加的是明天的
            //把明天会成熟的果子今天就加进来
            if (day < apples.length) {
                //明天一共成熟了apples[day]个果子,都是days[day]+day后过期,
                for (int i = 0; i < apples[day]; i++) {
                    //list.add(days[0]);
                    pq.add(days[day] + day);
                }
            }
            //System.out.println(pq+"day"+day);
            //if(haseat&&!pq.isEmpty()){}
            day++;/*[易错]这里就不需要再如果什么什么再day++了*/
        }
        return num;
    }
}
