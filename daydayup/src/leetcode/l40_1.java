package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class l40_1 {
    public static void main(String[] args) {
        //int[] candidates= {10,1,2,7,6,1,5};
        int[] candidates= {1,1,2};
        System.out.println(combinationSum2(candidates,8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i = 0; i < candidates.length-1; i++) {
            for (int j = 0;j<candidates.length-1-i;j++){
                if(candidates[j]>candidates[j+1]){
                    int temp = candidates[j];
                    candidates[j] = candidates[j+1];
                    candidates[j+1] = temp;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int startItem = 0;int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        backtrack(candidates,target,startItem,deque,res,sum);
        return res;
    }
    static void backtrack(int[] candidates, int target, int startItem,
                          Deque<Integer> deque,List<List<Integer>> res,
                          int sum  //sum加进去
    ){
        System.out.println("deque="+deque);
        //System.out.println("dequearr="+dequearr);

        if(sum>target){return;}
        else if(sum==target){
            ArrayList<Integer> arr = new ArrayList<>(deque);

                res.add(new ArrayList<>(arr));
            return;
        }
        for(int i = startItem;i<candidates.length;i++){
            /*关键是这一步!!!怎么去重,当与前一位相等,又i > startItem,直接跳过
            * for循环是什么?本质是一个树的一层!,那么当i > startItem时,说明以及不是最左的了,那就要去重
            * */
            if ( i > startItem && candidates[i] == candidates[i - 1] ) {
                System.out.println("有重复,跳");
                continue;
            }

            deque.add(candidates[i]);
            sum+=candidates[i];
            System.out.println("要回溯,回溯前path= "+deque);
            backtrack(candidates,target,i+1,deque,res,sum);
            sum-=deque.removeLast();
        }
    }
}
