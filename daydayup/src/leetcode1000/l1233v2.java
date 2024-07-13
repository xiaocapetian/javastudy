package leetcode1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 答案写的简洁,展开一点就是我写的v1
 */
public class l1233v2 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            String s1 = res.get(res.size() - 1);
            String s2 = folder[i];
            int s1len= s1.length();
            int s2len= s2.length();

            if (s1len >= s2len || //s2不可能是s1的子,直接接加
                    !(s1.equals(s2.substring(0, s1len))
                            && s2.charAt(s1len) == '/')) {
                res.add(folder[i]);
            }
        }
        return res;
    }
    // 作者：ylb
// 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/solutions/2099333/python3javacgo-yi-ti-shuang-jie-pai-xu-z-dha2/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
