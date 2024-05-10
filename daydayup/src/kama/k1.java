package kama;
import java.lang.*;
import java.util.*;

public class k1 {//记住在ACM中要写  class Main{  }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(sum(a,b));
        }
        scanner.close();
    }
    public static int sum(int a,int b){
        return a+b;
    }

    public static void main2(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            System.out.println(a + b);

        }

    }

}
