package leetcode;

/**
 * 双指针法,其实这个v3和v2是一个结果,都是从左数最大值,从右数最大值,但是我感觉v2可能更好理解一点
 */
public class l42v3 {
    public static void main(String[] args) {
        l42v3 s = new l42v3();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        s.trap(height);
    }
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //我要达到的目的就是说leftMax 是从左其最大值,其实在v2里就可以实现这个,v3理解起来困难一点
            System.out.println("height[left]=height["+left+"]="+height[left]);
            System.out.println("height[right]=height["+right+"]="+height[right]);
            //为什么要移动小的?其实就是移动完就计算这一条的雨水了,大的那个下一轮可能还会用上,你怎么能移动呢?
            if (height[left] < height[right]) {
                System.out.println("l<r,移动左边");
                ans += leftMax - height[left];
                System.out.println("leftMax="+leftMax+",ans+="+(leftMax - height[left])+",ans="+ans);
                left++;

            } else {
                System.out.println("l>=r,移动右边");
                ans += rightMax - height[right];
                System.out.println("rightMax="+rightMax+",ans+="+(rightMax - height[right])+",ans="+ans);
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