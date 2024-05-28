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
     *
     * 由于只关心某个字符是否出现，而不关心某个字符在原字符串的位置，因此可以将字符串使用 int 进行表示；
     * 由于使用 int 进行表示，因而可以使用「位运算」来判断某个字符是否可以被追加到当前状态中；
     *
     */
    public int maxLength(List<String> arr) {
        n = arr.size();
        //1.预处理掉「本身具有重复字符」的无效字符串，并去重；
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
        //set里的每个位掩码放进 hash[](int[])里
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
     * @param index 当前处理到的位掩码的索引(在 hash[] 中)。
     * @param cur 当前已选择的字符集合的位掩码。
     * @param remain 剩余未处理字符集合的位掩码。
     */
    void dfs(int index, int cur, int remain) {
        //如果当前已选择的字符集合的位掩码加上未处理的位掩码,都不如现在的res多,就算剩下的可以加进来,也不会超过res了,所以剪枝了
        if (get(cur | remain) <= ans) return;

        if (index == n) {//是否更新ans
            ans = Math.max(ans, get(cur));
            return;
        }
        // 如果之前已经选到的位掩码和这一位index是重叠的,那可以选这一位
        if ((hash[index] & cur) == 0) {
            dfs(index + 1, hash[index] | cur, remain - (remain & hash[index]));
        }
        // 不选择该数字
        dfs(index + 1, cur, remain);
    }

    /**
     *
     * @param cur 当前已选择的字符集合的位掩码,
     * @return 选的位掩码包含多少个1(有几个字母)
     */
    int get(int cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int ans = 0;
        //看着这长串里有几个1
        //比如 101010 ,先-000010 得到101000 ,再减001000,得到100000,最后减100000得到0
        //所以算出来一共3个1
        for (int i = cur; i > 0; i -= lowbit(i)) {ans++;}
        map.put(cur, ans);
        return ans;
    }

    /**
     * 怎么能忘了呢? 一个原码和补码相与&,得到什么呀?最后一个为1的位置
     * @param x
     * @return
     */
    int lowbit(int x) {
        return x & -x;
    }

//    作者：宫水三叶
//    链接：https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solutions/834718/gong-shui-san-xie-yi-ti-san-jie-jian-zhi-nfeb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
