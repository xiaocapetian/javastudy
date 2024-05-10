package nowcoder.huawei;

import java.util.Scanner;

/**
 * 这题学到什么呢?while (in.hasNext()) { 一定要改成这个,如果是默认的in.hasNextInt()直接错
 */
public class hj1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            //System.out.println(s);
            //System.out.println(Arrays.toString(s1));
            System.out.println(s1[s1.length-1].length());
        }
    }
}
