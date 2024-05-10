package leetcode500;

public class l509v1 {
    //动态规划五部曲
    /*dp数组以及下标ij的含义
    递推公式
    初始化
    遍历顺序,先遍历背包还是先遍历物品
    打印dp数组

    * */
    public int fib(int n) {//因为只用维护2个值,可以把数组简化成2个数维护
        if (n <= 1) return n;
//这道题dp数组就是dp斐波那契数列 dp[i]是第i个斐波那契数
        int sum =0;//这里用n+1,第0位不要了!
        //初始化
        int a = 0;
        int b = 1;
        for(int i = 2;i<=n;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;

    }
    public int fib2(int n) {
        if (n <= 1) return n;
//这道题dp数组就是dp斐波那契数列 dp[i]是第i个斐波那契数
        int[] dp = new int[n+1];//这里用n+1,第0位不要了!
        //初始化
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}
