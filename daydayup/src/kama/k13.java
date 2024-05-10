package kama;

import java.util.Scanner;

public class k13 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String in = sc.nextLine();
            String str = in.split(" ")[0];
            if(str.equals("@")){break;}
            int num = Integer.parseInt(in.split(" ")[1]);
            draw(str,num);
        }
    }
    public static void draw(String str,int num){
        for(int i = 0;i<num;i++){
            if(i<num-1){

                for(int empty = 0;empty<num-i-1;empty++){
                    System.out.print(" ");
                }
                for(int j= 0;j<2*i+1;j++){
                    if(j== 0){System.out.print(str);}
                    else if(j== 2*i){System.out.print(str);}
                    else {System.out.print(" ");}
                }
                System.out.println();
            }
            if(i==num-1){
                for(int empty = 0;empty<num-i-1;empty++){
                    System.out.print(" ");
                }
                for(int j= 0;j<2*i+1;j++){
                    System.out.print(str);

                }
                System.out.println();
            }

        }
        System.out.println();
    }
}
