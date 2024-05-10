package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj89v2 {

    private static Map<String, Integer> map = new HashMap<String, Integer>(){{
        put("2", 2);put("3", 3);put("4", 4);put("5", 5);
        put("6", 6);put("7", 7);put("8", 8);put("9", 9);
        put("10", 10);put("J", 11);put("Q", 12);put("K", 13);
        put("A", 1);
    }};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(str.contains("joker")){
            System.out.println("ERROR");
        }else{
            if(!dfs(str.split(" "), 0, "", 0)){
                System.out.println("NONE");
            }
        }
    }

    public static boolean dfs(String[] nums, int res, String exp, int n){
        for(int k = 0; k < nums.length; k++){
            String temp = nums[k];
            if(!temp.equals("")){
                nums[k] = "";    //已经使用过的牌标记为空字符串""
                int a = map.get(temp);
                if(n == 0){
                    if(dfs(nums, a,  exp + temp, n+1)||
                            dfs(nums, a,  exp + temp, n+1) ||
                            dfs(nums, a, exp + temp, n+1) ||
                            dfs(nums, a,  exp + temp, n+1) ){
                        return true;
                    }
                }else{
                    if(dfs(nums, res + a,  exp + "+" + temp, n+1) ||
                            dfs(nums, res - a,  exp + "-" + temp, n+1) ||
                            dfs(nums, res * a, exp + "*" + temp, n+1) ||
                            dfs(nums, res / a,  exp + "/" + temp, n+1) ){
                        return true;
                    }
                }
                nums[k] = temp; //恢复现场
            }
        }
        if(res == 24 && n == nums.length){
            System.out.println(exp);
            return true;
        }
        return false;
    }

}