package chongle.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class tt4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case]
            String s = in.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//
            int k = Integer.parseInt(s.split(" ")[1]);//分k段

            String s2 = in.nextLine();
            int[] nums = new int[n];
            System.out.println("n="+n+"k="+k);
            System.out.println("s2="+s2);
            for(int i =0;i<n;i++){
                nums[i] = Integer.parseInt(s2.split(" ")[i]);
            }
            System.out.println(Arrays.toString(nums));
            //System.out.println(get(nums,k));

        }
    }
    public static int get(int[] nums,int k){
        int n = nums.length;
        int[][] dp =new int[k+1][n+1];
        for(int i =1;i<=k;i++){
            for (int j =i;j<=n;i++){
                dp[i][j] =Math.max(dp[i][j-1],dp[i-1][j-1]);
                int x = 0;
                for (int p = j;p>i-1;p--){
                    x ^= nums[p-1];
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+x);
                }
            }
        }
        return dp[k][n];
    }
}
