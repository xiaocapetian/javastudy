package leetcode100;

public class l134 {
    //自己写的应该是对的,就是超时了QAQ,两层for的暴力解法
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0;i<gas.length;i++){
            int car=0;
            for (int step = 0,j = i;step<gas.length;step++,j++){
                if(j==gas.length)j=0;
                car = car +gas[j]-cost[j];
                if(car<0)break;
            }
            if(car>=0){return i;}
        }
        return -1;
    }
}
