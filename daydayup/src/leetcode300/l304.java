package leetcode300;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class l304 {
    class Solution {
        int[] init;
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
            this.init = new int[nums.length];
            for (int i = 0; i < init.length; i++) {
                init[i] = nums[i];
            }
        }

        public int[] reset() {
            for (int i = 0; i < init.length; i++) {
                nums[i] = init[i];
            }
            return nums;
        }

        public int[] shuffle() {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < init.length; i++) {
                list.add(init[i]);
            }
            Random random = new Random();
            int item = 0;
            while (!list.isEmpty()) {
                int r = random.nextInt(list.size());
                nums[item] = list.remove(r);
                item++;/*【易错】我怎么能弄丢了这句！！！*/
            }
            return nums;
        }
    }

}
