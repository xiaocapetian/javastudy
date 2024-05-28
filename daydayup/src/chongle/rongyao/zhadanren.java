package chongle.rongyao;

import java.util.List;

public class zhadanren {
    static int[][] map = new int[4][4];
    public static void main(String[] args) {

    }
    public static void get (List<List<Integer>> in){
        for (List<Integer> list : in) {
            Integer x = list.get(0);
            Integer y = list.get(1);
            Integer weili = list.get(2);
            if(map[x][y]<weili){map[x][y] = weili;}
            if(isvalid(x-1,y))dfsleft(x-1,y,weili-1);
            if(isvalid(x+1,y))dfsright(x+1,y,weili-1);
            if(isvalid(x,y-1))dfsup(x,y-1,weili-1);
            if(isvalid(x,y+1))dfsdown(x,y+1,weili-1);
        }

    }

    private static void dfsdown(Integer x, Integer y, int weili) {
        if(weili==1){
            map[x][y] = Math.max(map[x][y],weili);
            return;
        }
        if(isvalid(x+1,y)){dfsleft(x+1,y,weili-1);}
    }

    private static void dfsup(Integer x, Integer y, int weili) {
        if(weili==1){
            map[x][y] = Math.max(map[x][y],weili);
            return;
        }
        if(isvalid(x-1,y)){dfsleft(x-1,y,weili-1);}
    }

    public static void dfsleft(int x,int y , int weili){
        if(weili==1){
            map[x][y] = Math.max(map[x][y],weili);
            return;
        }
        if(isvalid(x,y-1)){dfsleft(x,y-1,weili-1);}
    }
    public static void dfsright(int x,int y , int weili){
        if(weili==1){
            map[x][y] = Math.max(map[x][y],weili);
            return;
        }
        if(isvalid(x,y+1)){dfsleft(x,y+1,weili-1);}
    }
    public static boolean isvalid(int x,int y){
        if(x<0||y<0||x>=map.length||y>=map[0].length){return false;}
        else return true;
    }
}
