package leetcode700;

public class l743v1 {
    //最初版本,v1问就是超时了
    private int[] canVisit;
    public int networkDelayTime(int[][] times, int n, int k) {
        canVisit = new int[n+1];
        for (int i = 1; i < canVisit.length; i++) {
            canVisit[i] = Integer.MAX_VALUE;
        }
        visit(times,k,0);
        int maxres = 0;
        for (int i = 1; i < canVisit.length; i++) {
            if(canVisit[i]==Integer.MAX_VALUE){return -1;}
            maxres = Math.max(canVisit[i],maxres);
        }
        return maxres;
    }

    private void visit(int[][] times,int k,int cost) {
        canVisit[k] = cost;
        for (int i = 0; i < times.length; i++) {
            if(times[i][0]==k&&cost+times[i][2]<canVisit[times[i][1]]){
                visit(times,times[i][1],cost+times[i][2]);
            }
        }
    }
}
