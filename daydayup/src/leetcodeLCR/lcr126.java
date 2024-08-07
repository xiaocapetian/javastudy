package leetcodeLCR;

/**
 * 简介的写法反手就是一个超时
 */
public class lcr126 {
    /**
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     *
     * @param n 给定 n ，
     * @return  请计算 F(n) 。
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1)+fib(n-2))%1000000007;
    }

}
