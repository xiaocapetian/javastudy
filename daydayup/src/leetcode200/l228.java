package leetcode200;

import java.util.ArrayList;
import java.util.List;

/**
 * [易错]nums[right]==nums[right-1]+1  这个+1别漏了啊
 */
public class l228 {
    /**
     * 重新刷一遍,就这么写
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int right=0;
        while (right<nums.length){
            int left=right;
            right++;
            while (nums[right]==nums[right-1]+1){
                right++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[left]);
            if(right==left-1){
                res.add(sb.toString());
            }else {
                sb.append("->").append(nums[right-1]);
            }
        }
        return res;
    }

    /**
     * 自己第一遍写的,复杂了
     * @param nums
     * @return
     */
    public List<String> summaryRanges3(int[] nums) {


        int left=0;
        int right=0;
        List<String> list = new ArrayList<>();
        if(nums.length==0)return list;
        while (right<nums.length){
            // System.out.println("right="+right+" , left="+left);
            if(left==right){
                right++;
                continue;
            }
            if(nums[right]==nums[right-1]+1){
                right++;
            }else {

                if(right!=left+1){
                    list.add(nums[left]+"->"+nums[right-1]);
                }else {
                    list.add(nums[left]+"");
                }
                left=right;
            }
        }

        if(right-1==left){
            list.add(nums[left]+"");
        }else {
            list.add(nums[left]+"->"+nums[right-1]);
        }
        return list;
    }

    /**
     * 人家写的就比我简短多了
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<String>();
        int right = 0;
        int n = nums.length;
        while (right < n) {
            int low = right;
            right++;
            while (right < n && nums[right] == nums[right - 1] + 1) {
                right++;
            }
            //int high = right - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < right - 1) {
                temp.append("->");
                temp.append(Integer.toString(nums[right - 1]));
            }
            res.add(temp.toString());
        }
        return res;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/summary-ranges/solutions/553645/hui-zong-qu-jian-by-leetcode-solution-6zrs/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
