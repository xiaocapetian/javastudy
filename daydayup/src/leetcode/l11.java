package leetcode;

public class l11 {
    //自己写的,,,
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftstep = 0, rightstep= 0;

        int area = Math.min(height[left],height[right])*(right-left);
        for (int i = 0; i < height.length-1; i++) {
            if(height[leftstep]<height[height.length-1-rightstep]){
                leftstep++;
            }else{
                rightstep++;
                }
            if(Math.min(height[leftstep],height[height.length-1-rightstep])*(height.length-1-rightstep-leftstep)>area){
                area = Math.min(height[leftstep],height[height.length-1-rightstep])*(height.length-1-rightstep-leftstep);
            }

        }
        return area;
    }

    //若向内 移动短板 ，水槽的短板 min(h[i],h[j])可能变大，因此下个水槽的面积 可能增大 。
    //若向内 移动长板 ，水槽的短板 min(h[i],h[j])不变或变小，因此下个水槽的面积 一定变小 。
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while(left < right) {
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]):
                    Math.max(res, (right - left) * height[right--]);//这里想写的简便就必须用right--了,要拆开就得按👇来写
        }
        return res;
    }

//    作者：Krahets
//    链接：https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    //4.6再写一遍咯
    public int maxArea3(int[] height) {
        int left=0;
        int right = height.length-1;
        int res = Math.min(height[left],height[right])*(right-left);
        while (left<right){
            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
            res = Math.max(Math.min(height[left],height[right])*(right-left),res);
        }
        return res;
    }
}
