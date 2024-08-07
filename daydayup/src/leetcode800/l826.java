package leetcode800;

import java.util.Arrays;

public class l826 {
    /**
     * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
     * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
     * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
     *
     * @param difficulty difficulty[i] 表示第 i 个工作的难度，
     * @param profit profit[i] 表示第 i 个工作的收益。
     * @param worker worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
     * @return 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Work[] works = new Work[difficulty.length];
        int res =0;
        for (int i = 0; i < difficulty.length; i++) {
            works[i] = new Work();
            works[i].profit = profit[i];
            works[i].difficulty = difficulty[i];
        }
        Arrays.sort(works,(o1, o2) -> {
            if(o1.profit!=o2.profit)return o2.profit-o1.profit;
            return o2.difficulty - o1.difficulty;
        });
        for(int i = 0;i<worker.length;i++){
            int j = 0;
            while (j<works.length&&works[j].difficulty>worker[i]){
                j++;
            }
            if(j!=works.length){
                res+=works[i].profit;
            }
        }
        return res;
    }
    class Work{
        int difficulty;
        int profit;
    }
}
