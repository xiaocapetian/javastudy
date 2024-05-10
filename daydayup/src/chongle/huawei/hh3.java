package chongle.huawei;

import java.util.*;

public class hh3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());//数
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                String[] s1 = s.split(" ");
                for (int j = 0; j < s1.length; j++) {
                    map[i][j] = Integer.parseInt(s1[j]);
                }
            }
            String s2 = sc.nextLine();//各节点剩余容量
            int[] shengyu = new int[n];
            for (int i = 0; i < shengyu.length; i++) {
                shengyu[i] = Integer.parseInt(s2.split(" ")[i]);
            }
            int failnode = Integer.parseInt(sc.nextLine());
            int yewuliang = Integer.parseInt(sc.nextLine());
            TreeMap<Integer,Integer> map2= new TreeMap<>();
            for (int i = 0; i < map[failnode].length; i++) {
                map2.put(map[failnode][i],i);
            }

            List<int[]> ints = Arrays.asList(map[failnode]);
           // Arrays.sort(ints,n);

            System.out.println();
            }

        }

}
