package leetcode;

import java.util.ArrayList;
import java.util.List;

/**这题很难,如果没做过肯定不会做,但是如果做过了,我应该记住
 * 思路我知道了，首先我要知道这个格雷码，n =1 长度1 n=2长度2 n=3长度4 n=4长度8
 * 很自然的想到 n位格雷码的长度是 n-1位格雷码长度 * 2;
 * 那怎么得到呢? 如果n-1位是合法的,把它给镜像对称了,就发现 n-1 , n-1 两端是合法的,只有中间和两端是相同的,且 左右对称一样就重复了.
 * 如果再把右边的每个数最前面加一位1,那就直接解决\
 * 最后一个问题怎么让一个数的二进制 前面+1呢 看看下面的head吧
 */
public class l89 {
    /**
     * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
     * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
     * 第一个整数是 0
     * 一个整数在序列中出现 不超过一次
     * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
     * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
     * @param n 给你一个整数 n ，
     * @return 返回任一有效的 n 位格雷码序列 。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>() {{
            add(0);
        }};
        int head = 1;
        for(int i = 0;i<n;i++){
            for(int j = res.size()-1;j>=0;j--){
                res.add(res.get(j)+head);
            }
            head = head<<1;
        }
        return res;
    }
}
