package kama;

import java.util.*;

public class k25 {
    //public static List<Integer> list = new ArrayList<>();
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = Integer.parseInt(str.split(" ")[0]);
            int m = Integer.parseInt(str.split(" ")[1]);
            int[][] map = new int[n+1][n+1];
            for(int i = 0;i<m;i++){
                String str2 = sc.nextLine();
                int city1 = Integer.parseInt(str2.split(" ")[0]);
                int city2 = Integer.parseInt(str2.split(" ")[1]);
                int len = Integer.parseInt(str2.split(" ")[2]);
                map[city1][city2] = len;
                map[city2][city1] = len;
            }
            String str3 = sc.nextLine();
            int city3 = Integer.parseInt(str3.split(" ")[0]);
            int city4 = Integer.parseInt(str3.split(" ")[1]);

            List<Integer> list = new ArrayList<>();
            Set<Integer> citySet = new HashSet<>();
            citySet.add(city3);
            // for(int i = 1;i<map.length;i++){
            //     for(int j = 1;j<map.length;j++){
            //         System.out.print(map[i][j]+",");
            //     }
            //     System.out.println();
            // }
            find(map,city3,city4,0,citySet,list);
            //System.out.println(list);
            if(list.isEmpty()){
                System.out.println("No path");
            }
            else{
                int res = list.get(0);
                for(int i = 0;i<list.size();i++){
                    if(res>list.get(i)){res = list.get(i);}
                }
                System.out.println(res);
            }
            //list.clear();
        }

    }
    public static void find(int[][] map, int cityA, int cityB, int len, Set<Integer> citySet, List<Integer> list){

        if(cityA==cityB){
            //System.out.println(citySet+","+len);
            list.add(len);
            return;
        }
        for(int i = 1;i<map.length;i++){
            if(map[cityA][i]!=0&&!citySet.contains(i)){
                len = len+map[cityA][i];
                citySet.add(i);
                find(map,i,cityB,len,citySet,list);
                len = len-map[cityA][i];
                citySet.remove(i);
            }
        }
    }
}
