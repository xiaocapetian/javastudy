package nowcoder.huawei;

import java.util.Scanner;

public class hj5 {
    //进制转换
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int num=0;
            for (int i = 2; i < s.length(); i++) {
                int wei;
                if(Character.isDigit(s.charAt(i))){wei =s.charAt(i)-'0';}
                else {
                    wei =s.charAt(i)-'A'+10;
                }
                num = num*16+wei;
            }
            System.out.println(num);
        }
    }
}
