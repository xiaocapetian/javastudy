package kama;

import java.util.Scanner;

public class k9 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //int num = sc.nextInt();
            String num = sc.nextLine();
            System.out.println(letter(num));
            System.out.println();
        }
    }
    public static int letter(String num){
        int sum = 0;
        for(int i = 0;i<num.length();i++){
            int wei = num.charAt(i)-'0';/*关键再此!!!*/
            if(wei%2==0){
                sum+=wei;
            }
        }
        return sum;
    }
}
