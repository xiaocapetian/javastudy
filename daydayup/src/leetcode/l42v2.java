package leetcode;

/**
 * 核心思路:对于每位置,维护一个从左边的最大值,维护一个右边的最大值,取(较小的 - 自己的高度)*1👈千万注意宽度是1,也就是说只能管自己这一长条的雨水!
 */
public class l42v2 {
    //这个思路更简单啊    竖着求的
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        //对于每位置,维护一个从左边的最大值,维护一个右边的最大值,也就是说leftMax[5]=8代表:5号位置左边的最大值是某个位置是8,至于是哪个位置是8?不关心
        //(如果左边没有值比自己大呢,那就是自己)
        //两最大值的小的那一个 - 自己本点的高度 就是装雨水的水条的高度👈千万注意是一个条!
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //从右数的最大值怎么获得?从右往左遍历可获得
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

