package kama;

import java.util.Scanner;

public class k2 {
    /*看一下区别在哪?
    * nextInt() 方法会读取下一个整数，并且会跳过任何分隔整数的空白字符，包括换行符、空格、制表符等*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int N = sc.nextInt(); // 读取整数N
            sc.nextLine(); // 读取换行符
            /*读取了一个整数之后,还有个换行符需要读*/
            /*用nextLine()读了再转Integer也是可以的*/
            //int N = Integer.parseInt(sc.nextLine()); // 读取整数N
            for (int i = 0; i < N; i++) {
                String[] line = sc.nextLine().split(" "); // 拆分行
                int a = Integer.parseInt(line[0]); // 解析第一个整数
                int b = Integer.parseInt(line[1]); // 解析第二个整数
                System.out.println(sum(a, b)); // 输出和
            }
        }
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int N = sc.nextInt(); // 读取整数N
            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(sum(a, b)); // 输出和
            }
        }
    }
    public static int sum(int a, int b) {
        return a + b;
    }


}
