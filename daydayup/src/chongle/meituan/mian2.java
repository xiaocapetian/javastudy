package chongle.meituan;

import java.util.*;
/*
2
3
1 2 3
4 5 6
* */
public class mian2 {

    static HashMap<List<int[]>,Integer> res = new HashMap<List<int[]>,Integer>();
    static int max;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //int a = in.nextInt();
            //int b = in.nextInt();
            //System.out.println(a + b);
            int high = Integer.parseInt(in.nextLine());
            int wide = Integer.parseInt(in.nextLine());
            int[][] map = new int[high][wide];
            //int[] hang = new int[wide];
            for(int i = 0 ; i<high ;i++ ){
                String str= in.nextLine();
                for(int j = 0 ; j<wide ;j++ ){

                    map[i][j] = Integer.parseInt(str.split(" ")[j]);
                }

            }

            max = map[0][0];
            dfs(map,0,0,new ArrayList<>(),map[0][0]);

            System.out.println("max = "+max);
            for(Map.Entry<List<int[]>,Integer> entry:res.entrySet()){
                if(entry.getValue()==max){
                    System.out.println("====");
                    List<int[]> path = entry.getKey();
                    for(int i = 0;i<path.size();i++){
                        System.out.println(Arrays.toString(path.get(i)));
                    }

                }

            }
        }
    }
    public static void dfs(int[][] map,int x,int y,List<int[]> path,int num){

        int[] wei = new int[]{x,y};
        path.add(wei);
        System.out.println("num="+num);
        for(int i = 0;i<path.size();i++){
            System.out.println(Arrays.toString(path.get(i)));
        }
        //num = num+map[x][y];//
        int high = map.length;
        int wide = map[0].length;
        if(x==high-1&&y==wide-1){
//            for(int i = 0;i<path.size();i++){
//                System.out.println(Arrays.toString(path.get(i)));
//            }
            List<int[]> ress = new ArrayList<>(path);
            //ress.
            res.put(ress,num);
            if(num>max){max = num;}
            return;
        }
        if(x==high-1){
            dfs(map,x,y+1,path,num+map[x][y+1]);
            path.remove(path.size()-1);
        }
        else if(y==wide-1){
            dfs(map,x+1,y,path,num+map[x+1][y]);
            path.remove(path.size()-1);
        }
        else {
            dfs(map,x,y+1,path,num+map[x][y+1]);
            path.remove(path.size()-1);
            dfs(map,x+1,y,path,num+map[x+1][y]);
            path.remove(path.size()-1);
        }



    }
}

