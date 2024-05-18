package leetcode700;

public class l743v1 {
    //最初版本,v1问就是超时了
    private int[] canVisit;

    /**
     *
     * @param times
     * @param n 有 n 个网络节点，标记为 1 到 n。
     * @param k 从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        canVisit = new int[n+1];
        for (int i = 1; i < canVisit.length; i++) {
            canVisit[i] = Integer.MAX_VALUE;
        }
        visit(times,k,0);
        int maxres = 0;
        for (int i = 1; i < canVisit.length; i++) {
            //如果有哪个点是这个说明到不了,那就返回-1
            if(canVisit[i]==Integer.MAX_VALUE){return -1;}
            //返回最大值
            maxres = Math.max(canVisit[i],maxres);
        }
        return maxres;
    }

    private void visit(int[][] times,int k,int cost) {
        canVisit[k] = cost;
        for (int i = 0; i < times.length; i++) {
            //遍历整个times如果哪条的起点是k,(也就是现在的节点),且过去了之后的总花费cost+times[i][2],比现在能到(times[i][1]终点)的花费还少,那就可以换
            //🌙那我怎么能这样遍历呢?这得多慢啊!所以v2v3改进
            if(times[i][0]==k&&cost+times[i][2]<canVisit[times[i][1]]){
                visit(times,times[i][1],cost+times[i][2]);
            }
        }
    }
}
