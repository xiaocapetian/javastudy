package leetcode100;

public class l122 {
    public int maxProfit(int[] prices) {

        //这题的关键是想通  p4-p1=p4-p3+p3-p2+p2-p1,只要其中的正的就行
        int res = 0;
        if(prices.length==1)return 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]-prices[i-1]>0){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
