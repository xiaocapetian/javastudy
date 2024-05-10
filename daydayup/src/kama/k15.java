package kama;

import java.util.Scanner;

public class k15 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            //int n = sc.nextInt();
            //sc.nextLine();
            for(int i = 0;i<n;i++){
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                pingjie(str1,str2);
            }
        }
    }
    public static void pingjie(String str1,String str2){
        //charstr1.toCharArray();
        System.out.print(str1.substring(0,str1.length()/2));
        System.out.print(str2);
        System.out.println(str1.substring(str1.length()/2,str1.length()));
    }
}
