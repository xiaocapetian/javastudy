package chongle.xiaohongshu2;

import java.util.Scanner;

public class tt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int n = Integer.parseInt(s);//n个笔记

            String s2 = sc.nextLine();
            int[] zanNum = new int[n];
            //int[] fensiNumBAN = new int[n];
            int min = Integer.MAX_VALUE;
            int max = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                zanNum[i] = Integer.parseInt(s2.split(" ")[i]);
                min = Math.min(min,zanNum[i]);
                max = Math.max(max,zanNum[i]);
                sum+=zanNum[i];
            }
            get(zanNum,sum,max,min,n);

        }
    }

    private static int[] get(int[] zanNum,int sum,int max,int min,int n) {

        int[] res = new int[n];
        if(n==2){
            if(zanNum[0]==zanNum[1]){res[0]=sum;res[1]=sum;return res;}
            if(zanNum[0]==max){res[0] = sum;res[1]=-1;return res;}
            else {res[1] = sum;res[0]=-1;return res;}
        }
        for (int i = 0; i < zanNum.length; i++) {
            if(zanNum[i]==max){res[i]=zanNum[i];}
            else if(zanNum[i]!=min){
                res[i] = (max-zanNum[i])*2-1;
            }else {//res[i]是最小值

            }

        }
        return res;
    }
}
