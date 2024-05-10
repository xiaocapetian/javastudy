package leetcode100;

import java.util.Arrays;

public class l179v1 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装Integer类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (- (sy*x + y) + sx*y + x);
            //这一步的意思就是,   x在前,y在后,拼接 - y在前,x在后,拼接
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/largest-number/solutions/715680/zui-da-shu-by-leetcode-solution-sid5/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
