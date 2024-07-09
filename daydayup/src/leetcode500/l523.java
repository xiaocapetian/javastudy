package leetcode500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 疯狂超时题,居然写了6版
 */

public class l523 {
    /**
     * @param nums
     * @param k
     * @return
     *
    //sum [j] - sum[i-1]=n*k
    //sum [j]/k - sum[i-1]/k = n  (n为整数)
    //sum [j]和sum[i-1]对k取余数相等
     我要往set里放sum[]%k,  直到放到一个已经存在的-----不要顺序,要不重复==>set
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];/*重点  如果sum往后推一位会更好   sum[0]空出来给0*/
        //
        for(int i = 0;i<nums.length;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 2;i<=nums.length;i++){/*易错 这地方就要  i<=nums.length了*/
            //if(set.contains(sum[i]%k)){return true;}
            //set.add(sum[i]%k);
            /*难点👆这是不行的!因为可能出现一位就成立了.那怎么办?*/
            set.add(sum[i-2]%k);
            if(set.contains(sum[i]%k)){return true;}
        }
        return false;
    }
    /**
     * 前缀和  看了很多眼答案  正确又又又又又超时
     */
    //sum [j] - sum[i-1]=n*k
    //sum [j]/k - sum[i-1]/k = n  (n为整数)
    //sum [j]和sum[i-1]对k取余数相等
    public boolean checkSubarraySum5(int[] nums, int k) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
            if(sum[i]%k==0)return true;
            for(int j = 0;j<i-1;j++){
                if(sum[j]%k==sum[i]%k){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 看一眼答案,说要前缀和 ,正确又又又超时
     */
    public boolean checkSubarraySum4(int[] nums, int k) {
        int[] qianzhuihe = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){/*易错 不能写 j<i-1!!*/
                qianzhuihe[j] = (qianzhuihe[j]+nums[i])%k;
                if( qianzhuihe[j] ==0)return true;
            }
            qianzhuihe[i] = nums[i];
        }

        return false;
    }
    /**
     * 正确但超时
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        int[] bp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            bp[i] = nums[i]%k;
            for(int j = i+1;j<nums.length;j++){
                bp[j] = (bp[j-1]+nums[j])%k;
                if(bp[j]==0)return true;
            }
        }
        return false;
    }
    /**
     * 正确但超内存
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int[][] bp = new int[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++){
            bp[i][i] = nums[i]%k;
        }
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                bp[i][j] = (bp[i][j-1]+nums[j])%k;
                if(bp[i][j]==0)return true;
            }
        }
        return false;
    }
    /**
     * 正确但超时
     */
    public boolean checkSubarraySum1(int[] nums, int k) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]%k);
            for(int j = 0;j< i ;j++){
                Integer poll = queue.poll();
                int yu = (poll+nums[i])%k;
                if(yu==0){
                    return true;
                }else {
                    queue.add(yu);
                }
            }
        }
        return false;
    }
}
