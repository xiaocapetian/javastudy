package leetcode1000;

public class l1094 {

    /**
     *
     * @param trips  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。
     * @param capacity 车上最初有 capacity 个空座位。
     * @return
     */
    //差分数组 将原数组的区间修改等价为差分数组的特定位置修改。
    //差分数组 执行「前缀计算」后得到的是 原数组
    //对 原数组 进行诸位累加「前缀计算」，所得到的数组为前缀和数组。
    public boolean carPooling(int[][] trips, int capacity) {

        int[] chafen =new int[1010];
        for (int i = 0; i < trips.length; i++) {
            int chengkeshu = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            chafen[from+1] += chengkeshu;
            chafen[to+1] -= chengkeshu;
            /*[易错]细节👆,为什么退后一位好呢,因为车牌会有从0到2这种,在下的对差分数组进行计算的时候呢,
            如果从1开始,会跳过第0站上车人数大于容量这一判断*/
        }
        // for (int i = 0; i < 10; i++) {
        //     System.out.print(chafen[i]+",");
        // }
        for (int i = 1; i < chafen.length; i++) {
            chafen[i]+=chafen[i-1];
            if(chafen[i]>capacity){
                return false;
            }
        }
        // System.out.println();
        // for (int i = 0; i < 10; i++) {
        //     System.out.print(chafen[i]+",");
        // }
        return true;
    }
    //自己写的,略慢,但是可以过
    public boolean carPoolingv1(int[][] trips, int capacity) {

        int[] nowchengke =new int[1000];
        for (int i = 0; i < trips.length; i++) {
            int chengkeshu = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            for(int j = from;j<to;j++){
                nowchengke[j]+=chengkeshu;
                if (nowchengke[j]>capacity){return false;}
            }

        }
        return true;
    }
}
