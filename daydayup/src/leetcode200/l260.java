package leetcode200;

public class l260 {
    /**
     *
     * @param nums 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     * @return  找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     */
    public int[] singleNumber(int[] nums) {

        int yihuo= 0;
        for (int num : nums) {
            yihuo ^=num;
        }
        int[] res = new int[2];
        //yihuo两个结果^的结果 他有什么用?用来求mask,靠mask把两个分开
        int mask = yihuo&(-yihuo);
        //mask是yihuo最右一个为1的位 ---为什么一定有,因为如果没有那就是0了,那这两个结果就像等了
        //为1什么意思,就是这两个结果在这一位不相等,
        //这样就把这两个分开了
        for (int num : nums) {
            if((mask&num)==0){
                //这一位不一样
                res[0]^=num;
            }else {
                res[1]^=num;
            }
        }
        return res;
    }
}
