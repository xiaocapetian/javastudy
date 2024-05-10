package kama;

import java.util.Scanner;

public class k4 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //List<Integer> list = new ArreyList<>();
            //String s = sc.nextLine();
            //String[] ss=s.split(" ");
            int N= sc.nextInt();
            if(N == 0){break;}

            int sum = 0;
            for(int i = 0;i<N;i++){
                sum = sc.nextInt()+sum ;
            }
            //int a = sc.nextInt();
            System.out.println(sum);
        }
    }
}
