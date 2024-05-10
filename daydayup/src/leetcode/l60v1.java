package leetcode;

import java.util.Arrays;

/**
 * 人家写的真清晰又简洁啊
 * 人家有什么特殊吗?
 * 如果k>一个块的范围
 *  k 直接 - 一个块的范围,这样来锁定目标区间
 */
public class l60v1 {


    //记录数字是否使用过
    private boolean[] used;
    //阶乘数组
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;//把n和k变成全局变量
        calculateFactorial(n);//计算阶乘数组factorial

        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();//path直接用StringBuilder 不用 List<Integer> path
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置[这就是我写的cenci吧]
     * @param path path直接用StringBuilder
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];//这一层每个包括多长区间
        System.out.println("index="+index+" cnt= "+cnt );
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {//如果k大于这个范围,减掉 这个范围
                k -= cnt;
                continue;
            }
            System.out.println("k= "+k);
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     *
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}

//作者：liweiwei1419
//        链接：https://leetcode.cn/problems/permutation-sequence/solutions/10642/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。