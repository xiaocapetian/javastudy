package kama;

import java.util.Scanner;

public class k24 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int i = 0;
            while(str.charAt(i)!=' '){
                i++;
            }

            String Xstr = str.substring(0,i);
            String Zstr = str.substring(i,str.length()).trim();
            //System.out.println(Xstr);
            //System.out.println(Zstr);
            char[] X = Xstr.toCharArray();
            char[] Z = Zstr.toCharArray();
            get(X,Z);
        }
    }
    public static void get(char[] X,char[] Z){
        int[][] bp = new int[X.length+1][Z.length+1];
        for(int i = 1;i<=X.length;i++) {
            boolean flag = true;
            for(int j = 1;j<=Z.length;j++) {
                if(X[i]==Z[j]&&flag){
                    flag = false;
                    bp[i][j] = Math.max(bp[i-1][j],bp[i][j-1])+1;
                }else{
                    bp[i][j] = Math.max(bp[i-1][j],bp[i][j-1]);
                }

            }

        }
        for(int i = 0;i<X.length;i++) {
            for(int j = 0;j<Z.length;j++) {
                System.out.print(bp[i][j]+",");
            }
            System.out.println();
        }
        System.out.println(bp[X.length-1][Z.length-1]);
    }
}
