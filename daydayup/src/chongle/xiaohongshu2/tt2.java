package chongle.xiaohongshu2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 难点在于对于0-1背包问题,明显一维dp数组比二维更简单
 */
public class tt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//n个账号
            int x = Integer.parseInt(s.split(" ")[1]);//恰好要x
            String s2 = sc.nextLine();
            int[] fensiNum = new int[n];
            int[] fensiNumBAN = new int[n];

            for (int i = 0; i < n; i++) {
                fensiNum[i]=Integer.parseInt(s2.split(" ")[i]);
                fensiNumBAN[i] = fensiNum[i]/2;
            }
            int min= Integer.MAX_VALUE;
            for (int a = 0; a < n; a++) {

                min = Math.min(get(x,fensiNum,fensiNumBAN,a),min);
            }
            if(min==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(min);
            }
        }
    }

    private static int get(int target, int[] fensiNum, int[] fensiNumBAN, int a) {
        int[] xianzaifensi=new int[fensiNum.length];
        for (int i = 0; i < fensiNumBAN.length; i++) {
            xianzaifensi[i] = fensiNumBAN[i];
        }
        xianzaifensi[a] = fensiNum[a];
        /*
        [1, 1, 1, 2, 5]
[0, 2, 1, 2, 5]
[0, 1, 3, 2, 5]
[0, 1, 1, 4, 5]
[0, 1, 1, 2, 10]
        * */
        int[] dp =new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i= 0 ;i<xianzaifensi.length;i++){
            for(int j =target;j>=xianzaifensi[i];j--){
                if(dp[j-xianzaifensi[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-xianzaifensi[i]]+1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[target];

    }
}
/*
5 8
1 2 3 4 10
* */