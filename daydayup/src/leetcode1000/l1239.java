package leetcode1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class l1239 {
    static Map<Integer, Integer> map = new HashMap<>();
    int n;
    int ans = Integer.MIN_VALUE;
    int[] hash;

    /**
     *
     * @param arr 字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。arr = ["un","iq","ue"]
     * @return 返回所有可行解 s 中最长长度。
     */
    public int maxLength(List<String> arr) {
        n = arr.size();
        HashSet<Integer> set = new HashSet<>();
        for (String s : arr) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = (int)(c - 'a');//这一位的数字是几呀？a是0,z是25
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t); //val的该字母的对应位置变成1
            }
            if (val != -1) set.add(val);//如果！=-1，说明这个string s里没有重复的字符，可以放进set里（且放进去的就是26位长的二进制数）
        }


        n = set.size();
        if (n == 0) return 0;
        hash = new int[n];

        int idx = 0;
        int total = 0;
        //set里的每个编码放进 int[]里
        for (Integer i : set) {
            hash[idx] = i;
            idx++;
            total |= i;
        }
        dfs(0, 0, total);
        return ans;
    }

    /**
     *
     * @param u 当前处理到的位掩码在 hash 中的索引。
     * @param cur 当前已选择的字符集合的位掩码。
     * @param total 剩余未处理字符集合的位掩码。
     */
    void dfs(int u, int cur, int total) {
        if (get(cur | total) <= ans) return;
        if (u == n) {
            ans = Math.max(ans, get(cur));
            return;
        }
        // 在原有基础上，选择该数字（如果可以）
        if ((hash[u] & cur) == 0) {
            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
        }
        // 不选择该数字
        dfs(u + 1, cur, total);
    }
    int get(int cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int ans = 0;
        for (int i = cur; i > 0; i -= lowbit(i)) ans++;
        map.put(cur, ans);
        return ans;
    }
    int lowbit(int x) {
        return x & -x;
    }

//    作者：宫水三叶
//    链接：https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solutions/834718/gong-shui-san-xie-yi-ti-san-jie-jian-zhi-nfeb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
