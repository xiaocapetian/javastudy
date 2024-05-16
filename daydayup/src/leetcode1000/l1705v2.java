package leetcode1000;

/**
 * 做了l1094之后想,这道题能不能用差分来做,做了后感觉不太可行,差分的话那一天吃不吃果子,如果吃是要记在差分数组上的,
 * 那吃掉了那一天就不会腐烂了,考虑起来还挺麻烦啊,,,
 */
public class l1705v2 {
    public int eatenApples(int[] apples, int[] days) {
        int res=0;
        int[] chafen = new int[20010];
        for (int i = 0; i < apples.length; i++) {
            //apples[i]=n 代表i天长出果子n个果子,
            //days[i] = m  i + days[i] 天时腐烂
            chafen[i+1]+=apples[i];//第i天长出apples[i]个果子
            chafen[i+days[i]+1]-=apples[i];//第i+days[i]天,apples[i]个果子腐烂
        }
        // for (int i = 0; i < chafen.length; i++) {
        //     chafen[i]--;
        // }
        for (int i = 1; i < chafen.length; i++) {
            if(chafen[i-1]>0){res++;chafen[i-1]--;
            }
            chafen[i]+=chafen[i-1];

        }
        return res;
    }
}
