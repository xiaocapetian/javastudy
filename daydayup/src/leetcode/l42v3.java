package leetcode;

public class l42v3 {
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    left++;
                } else {
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
