package kama;

import java.util.Scanner;

public class k16 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0;i<n;i++){
                String str = sc.nextLine();
                changePosition(str);
            }
        }
    }
    public static void changePosition(String str){
        for(int i = 0;i<str.length();i +=2){
            System.out.print(str.charAt(i+1));
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
    public static void changePosition2(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i +=2){
            sb.append(str.charAt(i+1));
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
