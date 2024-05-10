package nowcoder.huawei;

import java.util.Scanner;

public class hj3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int N = Integer.parseInt(in.nextLine());
            int[] map = new int[501];
            for (int i = 0;i<N;i++){
                int num = Integer.parseInt(in.nextLine());
                map[num] = 1;
            }
            for (int i = 1; i < map.length; i++) {
                if(map[i] == 1){
                    System.out.println(i);
                }
            }
        }
    }
}
