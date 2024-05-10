package chongle.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tt5 {
    static int res =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case]

            String s = in.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);//
            int m = Integer.parseInt(s.split(" ")[1]);//
            char[][] map =new char[n][m];
            for(int i =0;i<n;i++){
                String s2 = in.nextLine();
                char[] chars = s2.toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    map[i][i1] = chars[i1];
                }
            }
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    get(map,i,j);
                }
            }
            System.out.println(res);

        }

    }
    public static void get(char[][] map,int i,int j){
        backtrack(map,new ArrayList<>(),i,j,0);

    }
    public static void backtrack(char[][] map, List<Integer> path,int i,int j,int item){
        //if(sb.toString().equals("tencent")){return;}
        int n = map.length;
        int m = map[0].length;
        if (map[i][j]!="tencent".charAt(item)){return;}
        if (item==6){
            res++;
            return;}
        else {
            for(int i1 = 0;i1<4;i1++){
                if(i1==0&&i-1>=0){
                    item++;
                    backtrack(map,path,i-1,j,item);
                    item--;
                }
                if(i1==1&&j-1>=0){item++;
                    backtrack(map,path,i,j-1,item);item--;}
                if(i1==2&&i+1<n){item++;backtrack(map,path,i+1,j,item);item--;}
                if(i1==3&&j+1<m){item++;backtrack(map,path,i,j+1,item);item--;}


            }

        }

    }
}
