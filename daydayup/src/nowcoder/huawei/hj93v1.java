package nowcoder.huawei;

import java.util.LinkedList;
import java.util.Scanner;
public class hj93v1 {

    //这是回溯
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5 = 0;
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();
                if (cur % 5 == 0){
                    sum5 += cur;
                }else if (cur % 3 == 0){
                    sum3 += cur;
                }else{
                    list.add(cur);
                }
                sum += cur;
            }
            int target = sum/2 - sum3;
            if (sum % 2 != 0) System.out.println("false");
            else System.out.println(get(list, target));
        }
    }
    private static boolean get(LinkedList<Integer> list, int target){
        return helper(0, list, target);
    }
    private static boolean helper(int l, LinkedList<Integer> list, int target){
        //l 表示现在看第l个元素
        if (l == list.size()) return target == 0;
        //如果l已经到末尾了,看完了,比较target == 0吗?
        //如果还没到末尾
        //用第l个
        boolean b1 = helper(l + 1, list, target - list.get(l));
        // 或者不用第l个
        boolean b2 = helper(l + 1, list, target);
        return  b1||b2;
    }
}