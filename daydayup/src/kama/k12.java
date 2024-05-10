package kama;

import java.util.Scanner;

public class k12 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            printpic(n);
        }
    }
    public static void printpic(int n){
        for(int i = 0;i<n;i++){
            for(int jempty = 0;jempty<n-i-1;jempty++){
                System.out.print(" ");
            }
            int j = 0;
            for(;j<i+1;j++){
                System.out.print(j+1);
            }
            j--;
            for(;j>0;j--){
                System.out.print(j);
            }
            System.out.println();
        }
        for(int i = n-2;i>=0;i--){
            for(int jempty = 0;jempty<n-i-1;jempty++){
                System.out.print(" ");
            }
            int j = 0;
            for(;j<i+1;j++){
                System.out.print(j+1);
            }
            j--;
            for(;j>0;j--){
                System.out.print(j);
            }
            if(i>=0){
                System.out.println();}
        }
    }
}
