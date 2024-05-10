package leetcode100;

public class l134v2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int car = 0;
        int totalcar = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            car += (gas[i]-cost[i]);
            totalcar += (gas[i]-cost[i]);
            if(car<0){
                start = i+1;
                car = 0;
            }
        }
        //比起v1胜在哪?不用算路程step了
        if(totalcar<0)return -1;
        return start;//这很强,如果到最后start没变,那就还是那个最好的起点直接返回就行,但是怎么知道有没有变呢?
        //看总油料totalcar是不是大于0,这很难想的到啊
    }
}
