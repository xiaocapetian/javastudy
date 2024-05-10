package chongle.xiaohongshu2;

import java.util.Arrays;
import java.util.Scanner;

public class tt2v1 {
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

    private static int get(int x, int[] fensiNum, int[] fensiNumBAN, int a) {
        int[] xianzaifensi=new int[fensiNum.length];
        for (int i = 0; i < fensiNumBAN.length; i++) {
            xianzaifensi[i] = fensiNumBAN[i];
        }
        xianzaifensi[a] = fensiNum[a];
        int[][] dp = new int[fensiNum.length+1][x+1];

        for (int i = 0; i < dp.length; i++) {
            for(int j = 1; j < x+1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        /*
        [1, 1, 1, 2, 5]
[0, 2, 1, 2, 5]
[0, 1, 3, 2, 5]
[0, 1, 1, 4, 5]
[0, 1, 1, 2, 10]
        * */


        dp[0][0] = 0;
        for (int i = 0; i < fensiNum.length+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < fensiNum.length+1; i++) {
            //int min
            //for (int j = x; j-xianzaifensi[i-1] >=0; j--) {
            for (int j = 1; j < x+1; j++) {
                if(j-xianzaifensi[i-1] <0){
                    dp[i][j] =dp[i-1][j];
                }else if(dp[i-1][j-xianzaifensi[i-1]]!=Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-xianzaifensi[i-1]]+1);
                    //注意,这里只能向上一行看齐,为什么?因为这里是0-1背包问题,只能取一次,
                    // 如果是和这一行来比,那就是完全背包问题了
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("==========");

        return dp[fensiNum.length][x];

    }
}
