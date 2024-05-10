package leetcode;

public class l32 {
    public int longestValidParentheses(String s) {

        //Stack<Character> stack = new Stack<>();
        int stack = 0;
        char[] sarr = s.toCharArray();
        int[] dp = new int[sarr.length];
        for (int i = 0;i<sarr.length;i++) {
            if(sarr[i]=='('){
                stack++;
            }
            if(sarr[i]==')'){
                if(stack>0){
                    stack--;
                    int temp = dp[i-1]+2;
                    if(i-temp>0){dp[i] = dp[i-1]+2+dp[i-temp];}
                    else {dp[i] = dp[i-1]+2;}

                }else {

                }
            }
        }
        int max = 0;
//        for (int i = 0; i < dp.length; i++) {
//            if(max<dp[i]){
//                System.out.print(dp[i]+",");
//                max=dp[i];
//            }
//        }
        return max;
    }
}
