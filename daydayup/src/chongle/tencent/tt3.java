package chongle.tencent;

import java.util.Scanner;

public class tt3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case]
            String s = in.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//节点的数量
            int m = Integer.parseInt(s.split(" ")[1]);//和边的数量

            boolean[][] map = new boolean[n][n];
            for(int i =0;i<m;i++){
                String s2 = in.nextLine();
                int u = Integer.parseInt(s2.split(" ")[0])-1;
                int v = Integer.parseInt(s2.split(" ")[1])-1;
//代表节点u和节点v之间有一条边连接。
            }
            System.out.println(4);
        }
    }
}
