package kama;

import java.util.Scanner;

public class k10 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int M = sc.nextInt();
            int K = sc.nextInt();
            if(M ==0&&K==0){break;}
            System.out.println(phone(M,K));
        }
    }
    public static int phone(int m,int k){
        int price = m;

        int res = 0;
        while(price/k>0){
            int jiang1 = price/k;
            int yu = price%k;
            res+=jiang1*k;
            price = jiang1+yu;
        }
        res+=price;
        return res;
    }
}
