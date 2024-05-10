package leetcode100;

public class l134v1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//听了随想录之后自己写的,还是要有一个开车绕一圈2*gas.length-1的可能,不如直接v2
        //这得怎么想呢,和另一题一样,如果过去的和是负数,那就不要了!
        //感觉这个还是容易理解和想到的方法
        int car = 0;int start = 0;int step = 0;
        for (int i = 0; i < 2*gas.length-1; i++) {
            if(i>=gas.length){
                car = car +gas[i-gas.length]-cost[i-gas.length];
            }
            else{
                car = car +gas[i]-cost[i];
            }
            step++;
            if(car<0){//如果过去的和是负数,那就不要了!
                //从这个起点再出发
                car = 0;
                start = i+1;
                step = 0;
            }
            if(step == gas.length)return start;
        }
        return -1;

    }
}
