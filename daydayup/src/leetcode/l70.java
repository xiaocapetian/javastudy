package leetcode;

public class l70 {
    public int climbStairs(int n) {

        if(n==1||n==2)return n;
        int[] bp = new int[n+1];
        bp[1] = 1;
        bp[2] = 2;
        for(int i = 3;i<=n;i++){
            bp[i] = bp[i-1]+bp[i-2];
        }
        return bp[n];
    }
}
