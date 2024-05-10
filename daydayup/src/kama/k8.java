package kama;

import java.util.Scanner;

public class k8 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N  = sc.nextInt();
            if(N==0){break;}
            //List<Integer> list = new ArrayList<>();
            int[] arr = new int[N];//用数组最简单
            int sum = 0;
            for(int i = 0;i<N;i++){
                int a =sc.nextInt();
                //list.add(a);
                arr[i] = a;
                sum+=a;
            }
            int avg = sum/N;
            System.out.println(jimu(arr,avg));
            System.out.println();
        }
    }
    public static int jimu(int[] arr,int avg){
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>avg){
                res += arr[i]-avg;
            }
        }
        return res;
    }
}
