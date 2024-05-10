package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,n,k,0,new ArrayList<>());
        return result;
    }
    static void backtracking(List<List<Integer>> result,int n, int k,int startIndex,List<Integer> list){
        System.out.println("list = "+list);
        if(list.size()==k){
            //result.add(list);
            /*错误写法!!!!👆*/
            result.add(new ArrayList<>(list));//!!!!这里一定要注意!新建一个塞进去
            //为什么必须要新建一个塞进去,因为list是一个确定的地址(后面不停回溯的时候改list,result也跟着会变

            return;}
        for (int i = startIndex;
             //i<n;
             i<n-(k-list.size())+1;//剪枝!4个中取3个,那第一个起码从2开始
             i++){
            list.add(i+1);
            backtracking(result,n,k,i+1,list);
            list.remove(list.size()-1);
        }

    }
}
