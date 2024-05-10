package leetcode;

public class lcode_5v3 {
    //写l409不小心看错题了,结果l5还是出了一堆问题
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        char[] sarr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        int maxi=0;
        int maxj=0;
        /*正是问题多多啊*/     /*问题1:这个遍历顺序得注意*/
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if(sarr[j]==sarr[i]){
                    if(j-i ==1){dp[i][j]=2;}                             /*也就是说这里必须单独考虑*/
                    else {
                        if(dp[i+1][j-1]>0){dp[i][j]=dp[i+1][j-1]+2;}/*问题2:这里必须注意!不能相等就+2,👆还要看里面是不是字串,不是就百搭*/

                    }
                    //max = Math.max(max,dp[i][j]);
                    if(max<dp[i][j]){  /*问题4:👆那么这里就不能这样写了!!因为maxi,maxj只有在max更新的时候才更新!!!*/
                        max =dp[i][j];
                        maxi=i;
                        maxj=j;//问题3:这里求出最大值,但要返回的是具体字串怎么办可以记录一个maxi,maxj
                    }

                }
            }
        }
        // for (int i1 = 0; i1 < s.length(); i1++) {
        //     System.out.println(Arrays.toString(dp[i1]));
        // }
//System.out.println("maxi="+maxi+"maxj="+maxj);
        return s.substring(maxi,maxj+1);
    }
}
