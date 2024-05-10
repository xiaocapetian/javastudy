package kama;

import java.util.Scanner;

public class k6 {
    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            for(int i = 0;i<N;i++){
                int M = sc.nextInt();
                int sum = 0;
                for(int j = 0;j<M;j++){
                    sum = sum+ sc.nextInt();

                }
                System.out.println(sum);
                //System.out.println();
                if(i != N-1) System.out.println();
            }
        }
    }
    //只保证每组数据间是有空行的。但两组数据并没有空行
}
