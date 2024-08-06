package leetcodeLCR;

/**
 * 动态规划安排上！
 */
public class lcr126v1 {
    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     *
     * @param n 给定 n ，
     * @return  请计算 F(n) 。
     */
    public int fib(int n) {

        int[] fib = new int[n+1];
        fib[0] = 0;
        if(n==0)return 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i-1] + fib[i-2])%1000000007;
        }
        return fib[n];
    }
}
