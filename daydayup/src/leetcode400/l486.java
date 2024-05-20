package leetcode400;

public class l486 {
    //递归法的关键是想到要按这个框架来写！
    public boolean predictTheWinner(int[] nums) {

        //我抄!如果是偶数,先来的一定能胜利
        if(nums.length%2==0){return true;}
        /*
         *为什么呢?只要总和是偶数, 1 2 3 4 5 6 ,我看中了偶数 2 4 6大于奇数1 3 5
         * 我上来选偶数,小二只能选两个奇数选一个,我再选偶数,那你还是只能选奇数,
         */

        int res = find(nums, 0, nums.length - 1, 1);
        if(res>=0)return true;
        else return false;
    }
    /**
     * @param nums 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
     * @param start
     * @param end
     * @param turn turn是1表示1号玩家，是2表示2号玩家
     * @return
     */
    private int find(int[] nums,int start ,int end,int turn) {
        //如果范围里就剩1个了，那就返回呗，如果是1号玩家，那就是正的，否则是负的
        if(start==end){return nums[start]*turn;}
        //那么如果是1号选，那就是正的，2号选就是负的，那么现在是choose start还是end呢？
        int ifchooseStart = turn*nums[start]+find(nums,start+1,end,-turn);
        int ifchooseEnd =  turn*nums[end]+find(nums,start,end-1,-turn);
        //选一个对自己最有利的呀
        if(turn>0){
            return Math.max(ifchooseStart,ifchooseEnd);
        }else {
            return Math.min(ifchooseStart,ifchooseEnd);
        }
    }


}
