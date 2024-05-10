package chongle.tencent;

import java.util.Scanner;

public class tt {
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
                String str = s2.split(" ")[2];
                if(str.equals("W")){
                    map[u][v]=true;
                    map[v][u]=true;
                }

            }
            int res=0;
            for(int i =0;i<n;i++){
                if(ifhao(map,i,n)){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
    private static boolean ifhao(boolean[][] map,int i ,int n){
        for(int j = 0;j<n;j++){
            if(map[i][j]){
                return false;
            }
        }
        return true;
    }
}
